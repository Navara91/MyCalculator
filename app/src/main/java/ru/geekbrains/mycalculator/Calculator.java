package ru.geekbrains.mycalculator;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class Calculator implements Parcelable {

    TextView resultTv;
    private Button equalBtn, clearBtn, divBtn, multiBtn, minusBtn, plusBtn, zeroBtn, oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn, dotBtn;

    private double valueOne = 0.0;
    private double valueTwo = 0.0;
    private boolean isFirstValue = true;
    private boolean isFirstAction = true;
    private String action = null;

    private MainActivity mainActivity;

    // Конструктор класса Logic запускается один раз при его инициализации
    public Calculator(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        // Инициализация переменных
        initView();
        // Установка начального значения поля с результатом
        resultTv.setText(zeroBtn.getText().toString());
        // Подключение слушателей событий к кнопкам
        initClickListeners();
    }

    void showResult(Button digit){
        if (isFirstValue) {
            resultTv.setText(digit.getText().toString());
            isFirstValue = false;
        } else
            resultTv.setText(String.format("%s%s", resultTv.getText().toString(), digit.getText().toString()));
    }

    private void setAction(Button button){
        if (isFirstAction) {
            valueOne = Double.parseDouble(resultTv.getText().toString());
            isFirstValue = true;
            action = button.getText().toString();
            resultTv.setText(String.valueOf(valueOne) + button.getText().toString());
            isFirstAction = false;
        }
    }

    protected Calculator(Parcel in) {
        valueOne = in.readDouble();
        valueTwo = in.readDouble();
        isFirstValue = in.readByte() != 0;
        isFirstAction = in.readByte() != 0;
        action = in.readString();
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

    private void initView() {
        resultTv = mainActivity.findViewById(R.id.result_tv);
        clearBtn = mainActivity.findViewById(R.id.clear_button);
        equalBtn = mainActivity.findViewById(R.id.equal_button);

        oneBtn = mainActivity.findViewById(R.id.digit_one_button);
        twoBtn = mainActivity.findViewById(R.id.digit_two_button);
        threeBtn = mainActivity.findViewById(R.id.digit_three_button);
        fourBtn = mainActivity.findViewById(R.id.digit_four_button);
        fiveBtn = mainActivity.findViewById(R.id.digit_five_button);
        sixBtn = mainActivity.findViewById(R.id.digit_six_button);
        sevenBtn = mainActivity.findViewById(R.id.digit_seven_button);
        eightBtn = mainActivity.findViewById(R.id.digit_eight_button);
        nineBtn = mainActivity.findViewById(R.id.digit_nine_button);
        zeroBtn = mainActivity.findViewById(R.id.digit_zero_button);

        dotBtn = mainActivity.findViewById(R.id.dot_button);
        plusBtn = mainActivity.findViewById(R.id.plus_button);
        minusBtn = mainActivity.findViewById(R.id.minus_button);
        multiBtn = mainActivity.findViewById(R.id.multi_button);
        divBtn = mainActivity.findViewById(R.id.division_button);
    }

    private void initClickListeners() {

        oneBtn.setOnClickListener(v -> showResult(oneBtn));
        twoBtn.setOnClickListener(v -> showResult(twoBtn));
        threeBtn.setOnClickListener(v -> showResult(threeBtn));
        fourBtn.setOnClickListener(v -> showResult(fourBtn));
        fiveBtn.setOnClickListener(v -> showResult(fiveBtn));
        sixBtn.setOnClickListener(v -> showResult(sixBtn));
        sevenBtn.setOnClickListener(v -> showResult(sevenBtn));
        eightBtn.setOnClickListener(v -> showResult(eightBtn));
        nineBtn.setOnClickListener(v -> showResult(nineBtn));
        zeroBtn.setOnClickListener(v -> showResult(zeroBtn));

        plusBtn.setOnClickListener(v -> setAction(plusBtn));
        minusBtn.setOnClickListener(v -> setAction(minusBtn));
        multiBtn.setOnClickListener(v -> setAction(multiBtn));
        divBtn.setOnClickListener(v -> setAction(divBtn));

        clearBtn.setOnClickListener(v -> {
                    resultTv.setText(zeroBtn.getText().toString());
                    isFirstValue = true;
                    isFirstAction = true;
                }
        );

        equalBtn.setOnClickListener(v -> {
            valueTwo = Double.parseDouble(resultTv.getText().toString());
            if (action == plusBtn.getText().toString()) {
                double valueResult = valueOne + valueTwo;
                resultTv.setText(String.valueOf(valueResult));
                valueOne = valueResult;
                isFirstValue = true;
                isFirstAction = true;
                action = "";
            }
            if (action == minusBtn.getText().toString()) {
                double valueResult = valueOne - valueTwo;
                resultTv.setText(String.valueOf(valueResult));
                valueOne = valueResult;
                isFirstValue = true;
                isFirstAction = true;
                action = "";
            }
            if (action == multiBtn.getText().toString()) {
                double valueResult = valueOne * valueTwo;
                resultTv.setText(String.valueOf(valueResult));
                valueOne = valueResult;
                isFirstValue = true;
                isFirstAction = true;
                action = "";
            }
            if (action == divBtn.getText().toString()) {
                double valueResult = valueOne / valueTwo;
                resultTv.setText(String.valueOf(valueResult));
                valueOne = valueResult;
                isFirstValue = true;
                isFirstAction = true;
                action = "";
            }
        });
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(valueOne);
        dest.writeDouble(valueTwo);
        dest.writeByte((byte) (isFirstValue ? 1 : 0));
        dest.writeByte((byte) (isFirstAction ? 1 : 0));
        dest.writeString(action);
    }
}