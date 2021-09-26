package ru.geekbrains.mycalculator;

import android.os.Parcel;
import android.os.Parcelable;

class Calculator implements Parcelable, Constants {

    private double firstValue;
    private double secondValue;
    private double currentNumber = 0.0;
    private boolean isFirstValue = true;
    private boolean isFirstAction = true;
    private ACTIONS actions = null;
    private ACTIONS currentAction = null;
    private String equal = "";
    private double finalResult = 0.0;

    //пустой конструктор для вызова класса в майнАктивити
    Calculator(){

    }

    protected Calculator(Parcel in) {
        firstValue = in.readDouble();
        secondValue = in.readDouble();
        currentNumber = in.readDouble();
        isFirstValue = in.readByte() != 0;
        isFirstAction = in.readByte() != 0;
        equal = in.readString();
        finalResult = in.readDouble();
    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    // метод получения числовых аргументов для арифметических действий
    String addDigit(int newDigit) {

        if (currentAction == null) {
            if (isFirstValue) {
                isFirstValue = false;
                firstValue = newDigit;
            } else
                firstValue = firstValue * 10 + newDigit;
            return String.valueOf(firstValue);
        } else {
            if (isFirstValue) {
                isFirstValue = false;
                secondValue = newDigit;
            } else
                secondValue = secondValue * 10 + newDigit;
            return fullExpression(firstValue, secondValue, currentAction);
        }

    }

    // метод для передачи арифметического действия
    String operation(ACTIONS actions) {

        isFirstValue = true;
        currentAction = actions;

        switch (actions) {
            case ACTION_PLUS:
                return String.format("%s +", String.valueOf(firstValue));
            case ACTION_MINUS:
                return String.format("%s -", String.valueOf(firstValue));
            case ACTION_MULTI:
                return String.format("%s *", String.valueOf(firstValue));
            case ACTION_DIVISION:
                return String.format("%s /", String.valueOf(firstValue));
            default:
                return "";
        }
    }

    String fullExpression(double argumentOne, double argumentTwo, ACTIONS action) {
        switch (action) {
            case ACTION_PLUS:
                return String.format("%s + %s", argumentOne, argumentTwo);
            case ACTION_MINUS:
                return String.format("%s - %s", argumentOne, argumentTwo);
            case ACTION_MULTI:
                return String.format("%s * %s", argumentOne, argumentTwo);
            case ACTION_DIVISION:
                return String.format("%s / %s", argumentOne, argumentTwo);
            default:
                return "";
        }
    }

    double showResult(){
        isFirstValue = true;
        switch (currentAction){
            case ACTION_PLUS:
                currentAction = null;
                return firstValue = firstValue + secondValue;
            case ACTION_MINUS:
                currentAction = null;
                return firstValue = firstValue - secondValue;
            case ACTION_MULTI:
                currentAction = null;
                return firstValue = firstValue * secondValue;
            case ACTION_DIVISION:
                currentAction = null;
                return firstValue = firstValue / secondValue;
            default:
                return 0;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(firstValue);
        dest.writeDouble(secondValue);
        dest.writeDouble(currentNumber);
        dest.writeByte((byte) (isFirstValue ? 1 : 0));
        dest.writeByte((byte) (isFirstAction ? 1 : 0));
        dest.writeString(equal);
        dest.writeDouble(finalResult);
    }
}