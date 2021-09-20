package ru.geekbrains.mycalculator;

import android.widget.Button;
import android.widget.TextView;

class Calculator {

    private TextView resultTv;
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
        resultTv.setText("0");
        // Подключение слушателей событий к кнопкам
        ButtonClick();
    }

    private void initView() {
        resultTv = mainActivity.findViewById(R.id.result_Tv);
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

    private void ButtonClick() {

        oneBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText("1");
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), "1"));
                }
        );
        twoBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText("2");
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), "2"));
                }
        );
        threeBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText("3");
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), "3"));
                }
        );
        fourBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText("4");
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), "4"));
                }
        );
        fiveBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText("5");
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), "5"));
                }
        );
        sixBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText("6");
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), "6"));
                }
        );
        sevenBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText("7");
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), "7"));
                }
        );
        eightBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText("8");
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), "8"));
                }
        );
        nineBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText("9");
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), "9"));
                }
        );
        zeroBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText("0");
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), "0"));
                }
        );
        clearBtn.setOnClickListener(v -> {
                    resultTv.setText("0");
                    isFirstValue = true;
                    isFirstAction = true;
                }
        );

        plusBtn.setOnClickListener(v -> {
            if (isFirstAction) {
                valueOne = Double.parseDouble(resultTv.getText().toString());
                isFirstValue = true;
                action = "+";
                resultTv.setText(String.valueOf(valueOne) + "+");
                isFirstAction = false;
            }
        });

        minusBtn.setOnClickListener(v -> {
            if (isFirstAction) {
                valueOne = Double.parseDouble(resultTv.getText().toString());
                isFirstValue = true;
                action = "-";
                resultTv.setText(String.valueOf(valueOne) + "-");
                isFirstAction = false;
            }
        });

        multiBtn.setOnClickListener(v -> {
            if (isFirstAction) {
                valueOne = Double.parseDouble(resultTv.getText().toString());
                isFirstValue = true;
                action = "*";
                resultTv.setText(String.valueOf(valueOne) + "*");
                isFirstAction = false;
            }
        });

        divBtn.setOnClickListener(v -> {
            if (isFirstAction) {
                valueOne = Double.parseDouble(resultTv.getText().toString());
                isFirstValue = true;
                action = "/";
                resultTv.setText(String.valueOf(valueOne) + "/");
                isFirstAction = false;
            }
        });

        equalBtn.setOnClickListener(v -> {
            valueTwo = Double.parseDouble(resultTv.getText().toString());
            if (action == "+") {
                double valueResult = valueOne + valueTwo;
                resultTv.setText(String.valueOf(valueResult));
                valueOne = valueResult;
                isFirstValue = true;
                isFirstAction = true;
                action = "";
            }
            if (action == "-") {
                double valueResult = valueOne - valueTwo;
                resultTv.setText(String.valueOf(valueResult));
                valueOne = valueResult;
                isFirstValue = true;
                isFirstAction = true;
                action = "";
            }
            if (action == "*") {
                double valueResult = valueOne * valueTwo;
                resultTv.setText(String.valueOf(valueResult));
                valueOne = valueResult;
                isFirstValue = true;
                isFirstAction = true;
                action = "";
            }
            if (action == "/") {
                double valueResult = valueOne / valueTwo;
                resultTv.setText(String.valueOf(valueResult));
                valueOne = valueResult;
                isFirstValue = true;
                isFirstAction = true;
                action = "";
            }
        });
    }
}