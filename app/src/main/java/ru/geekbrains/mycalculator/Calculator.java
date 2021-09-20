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
        resultTv.setText(zeroBtn.getText().toString());
        // Подключение слушателей событий к кнопкам
        ButtonClick();
    }

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

    private void ButtonClick() {

        oneBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText(oneBtn.getText().toString());
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), oneBtn.getText().toString()));
                }
        );
        twoBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText(twoBtn.getText().toString());
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), twoBtn.getText().toString()));
                }
        );
        threeBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText(threeBtn.getText().toString());
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), threeBtn.getText().toString()));
                }
        );
        fourBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText(fourBtn.getText().toString());
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), fourBtn.getText().toString()));
                }
        );
        fiveBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText(fiveBtn.getText().toString());
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), fiveBtn.getText().toString()));
                }
        );
        sixBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText(sixBtn.getText().toString());
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), sixBtn.getText().toString()));
                }
        );
        sevenBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText(sevenBtn.getText().toString());
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), sevenBtn.getText().toString()));
                }
        );
        eightBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText(eightBtn.getText().toString());
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), eightBtn.getText().toString()));
                }
        );
        nineBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText(nineBtn.getText().toString());
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), nineBtn.getText().toString()));
                }
        );
        zeroBtn.setOnClickListener(v -> {
                    if (isFirstValue) {
                        resultTv.setText(zeroBtn.getText().toString());
                        isFirstValue = false;
                    } else
                        resultTv.setText(String.format("%s%s", resultTv.getText().toString(), zeroBtn.getText().toString()));
                }
        );
        clearBtn.setOnClickListener(v -> {
                    resultTv.setText(zeroBtn.getText().toString());
                    isFirstValue = true;
                    isFirstAction = true;
                }
        );

        plusBtn.setOnClickListener(v -> {
            if (isFirstAction) {
                valueOne = Double.parseDouble(resultTv.getText().toString());
                isFirstValue = true;
                action = plusBtn.getText().toString();
                resultTv.setText(String.valueOf(valueOne) + plusBtn.getText().toString());
                isFirstAction = false;
            }
        });

        minusBtn.setOnClickListener(v -> {
            if (isFirstAction) {
                valueOne = Double.parseDouble(resultTv.getText().toString());
                isFirstValue = true;
                action = minusBtn.getText().toString();
                resultTv.setText(String.valueOf(valueOne) + minusBtn.getText().toString());
                isFirstAction = false;
            }
        });

        multiBtn.setOnClickListener(v -> {
            if (isFirstAction) {
                valueOne = Double.parseDouble(resultTv.getText().toString());
                isFirstValue = true;
                action = multiBtn.getText().toString();
                resultTv.setText(String.valueOf(valueOne) + multiBtn.getText().toString());
                isFirstAction = false;
            }
        });

        divBtn.setOnClickListener(v -> {
            if (isFirstAction) {
                valueOne = Double.parseDouble(resultTv.getText().toString());
                isFirstValue = true;
                action = divBtn.getText().toString();
                resultTv.setText(String.valueOf(valueOne) + divBtn.getText().toString());
                isFirstAction = false;
            }
        });

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
}