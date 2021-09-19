package ru.geekbrains.mycalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView currentDataTv;
    private TextView resultTv;
    private Button equalBtn, clearBtn, divBtn, multiBtn, minusBtn, plusBtn, zeroBtn, oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn, dotBtn;

    private double valueOne = 0.0;
    private double valueTwo = 0.0;
    private boolean isFirstValue = true;
    private boolean isFirstAction = true;
    private String action = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        resultTv.setText("0");

        ButtonClick();
    }

    private void initView() {
        currentDataTv = findViewById(R.id.current_data_Tv);
        resultTv = findViewById(R.id.result_Tv);
        clearBtn = findViewById(R.id.clear_button);
        equalBtn = findViewById(R.id.equal_button);

        oneBtn = findViewById(R.id.digit_one_button);
        twoBtn = findViewById(R.id.digit_two_button);
        threeBtn = findViewById(R.id.digit_three_button);
        fourBtn = findViewById(R.id.digit_four_button);
        fiveBtn = findViewById(R.id.digit_five_button);
        sixBtn = findViewById(R.id.digit_six_button);
        sevenBtn = findViewById(R.id.digit_seven_button);
        eightBtn = findViewById(R.id.digit_eight_button);
        nineBtn = findViewById(R.id.digit_nine_button);
        zeroBtn = findViewById(R.id.digit_zero_button);

        dotBtn = findViewById(R.id.dot_button);
        plusBtn = findViewById(R.id.plus_button);
        minusBtn = findViewById(R.id.minus_button);
        multiBtn = findViewById(R.id.multi_button);
        divBtn = findViewById(R.id.division_button);
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
            if (action=="+"){
                double valueResult = valueOne + valueTwo;
                resultTv.setText(String.valueOf(valueResult));
                valueOne = valueResult;
                isFirstValue = true;
                isFirstAction = true;
                action = "";
            }
            if (action=="-"){
                double valueResult = valueOne - valueTwo;
                resultTv.setText(String.valueOf(valueResult));
                valueOne = valueResult;
                isFirstValue = true;
                isFirstAction = true;
                action = "";
            }
            if (action=="*"){
                double valueResult = valueOne * valueTwo;
                resultTv.setText(String.valueOf(valueResult));
                valueOne = valueResult;
                isFirstValue = true;
                isFirstAction = true;
                action = "";
            }
            if (action=="/"){
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