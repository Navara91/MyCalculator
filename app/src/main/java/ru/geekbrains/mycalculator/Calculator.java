package ru.geekbrains.mycalculator;

import android.os.Parcel;
import android.os.Parcelable;

class Calculator implements Parcelable {

    private double firstValue = 0.0;
    private double currentNumber = 0.0;
    private boolean isFirstValue = true;
    private boolean isFirstAction = true;
    private String action = null;
    private String equal = null;
    private double finalResult = 0.0;
    private String plus = "+";
    private String minus = "-";
    private String multi = "*";
    private String division = "/";


    public Calculator() {
        this.firstValue = firstValue;
        this.currentNumber = currentNumber;
        this.isFirstValue = isFirstValue;
        this.isFirstAction = isFirstAction;
        this.action = action;
        this.equal = equal;
        this.finalResult = finalResult;
    }

    // метод получения чисел для арифметических действий
    public double addDigit(int newDigit) {
        if (isFirstValue) {
            isFirstValue = false;
            return currentNumber = newDigit;
        } else
            return currentNumber = currentNumber * 10 + newDigit;
    }

    // метод арифметического действия
    double operation(String action) {

        isFirstValue = true;
        if (action == "+") {
            firstValue = currentNumber;
            return firstValue;
        }
        if (action == "-") {
            firstValue = currentNumber;
            return firstValue;
        }
        if (action == "*") {
            firstValue = currentNumber;
            return firstValue;
        }
        if (action == "/") {
            firstValue = currentNumber;
            return firstValue;
        }
        return firstValue = 0;
    }

    double showResult(String equal){
        isFirstValue = true;
        switch (action){
            case "+":
                return finalResult = firstValue + currentNumber;
            case "-":
                return finalResult = firstValue - currentNumber;
            case "*":
                return finalResult = firstValue * currentNumber;
            case "/":
                return finalResult = firstValue / currentNumber;
        }
        return finalResult = 0;
    }

    protected Calculator(Parcel in) {
        firstValue = in.readDouble();
        currentNumber = in.readDouble();
        isFirstValue = in.readByte() != 0;
        isFirstAction = in.readByte() != 0;
        action = in.readString();
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(firstValue);
        dest.writeDouble(currentNumber);
        dest.writeByte((byte) (isFirstValue ? 1 : 0));
        dest.writeByte((byte) (isFirstAction ? 1 : 0));
        dest.writeString(action);
        dest.writeDouble(finalResult);

    }
}