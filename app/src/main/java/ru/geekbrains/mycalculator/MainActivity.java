package ru.geekbrains.mycalculator;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Constants{

    private TextView resultTv;
    private Button clearBtn;
    private Button equalBtn;

    private Button oneBtn;
    private Button twoBtn;
    private Button threeBtn;
    private Button fourBtn;
    private Button fiveBtn;
    private Button sixBtn;
    private Button sevenBtn;
    private Button eightBtn;
    private Button nineBtn;
    private Button zeroBtn;
    private Button dotBtn;

    private Button plusBtn;
    private Button minusBtn;
    private Button multiBtn;
    private Button divBtn;

    private static final String COUNTER_KEY = "COUNTER_KEY";
    // Основной класс, реализующий логику калькулятора (здесь он создаётся, но не инициализируется,
    // потому что здесь ещё MainActivity не создана
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация переменных
        initView();
        // Подключение слушателей событий к кнопкам
        initClickListeners();
        if (savedInstanceState == null) {
            calculator = new Calculator();
            // Установка начального значения поля с результатом
            resultTv.setText(String.valueOf(zeroBtn));
        } else {
            calculator = savedInstanceState.getParcelable(COUNTER_KEY);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(COUNTER_KEY, calculator);
        super.onSaveInstanceState(outState);
    }

    private void initView() {
        resultTv = findViewById(R.id.result_tv);
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

    private void initClickListeners() {

        oneBtn.setOnClickListener(v -> resultTv.setText(calculator.addDigit(1)));
        twoBtn.setOnClickListener(v -> resultTv.setText(calculator.addDigit(2)));
        threeBtn.setOnClickListener(v -> resultTv.setText(calculator.addDigit(3)));
        fourBtn.setOnClickListener(v -> resultTv.setText(calculator.addDigit(4)));
        fiveBtn.setOnClickListener(v -> resultTv.setText(calculator.addDigit(5)));
        sixBtn.setOnClickListener(v -> resultTv.setText(calculator.addDigit(6)));
        sevenBtn.setOnClickListener(v -> resultTv.setText(calculator.addDigit(7)));
        eightBtn.setOnClickListener(v -> resultTv.setText(calculator.addDigit(8)));
        nineBtn.setOnClickListener(v -> resultTv.setText(calculator.addDigit(9)));
        zeroBtn.setOnClickListener(v -> resultTv.setText(calculator.addDigit(0)));

        plusBtn.setOnClickListener(v -> resultTv.setText(calculator.operation(ACTIONS.ACTION_PLUS)));
        minusBtn.setOnClickListener(v -> resultTv.setText(calculator.operation(ACTIONS.ACTION_MINUS)));
        multiBtn.setOnClickListener(v -> resultTv.setText(calculator.operation(ACTIONS.ACTION_MULTI)));
        divBtn.setOnClickListener(v -> resultTv.setText(calculator.operation(ACTIONS.ACTION_DIVISION)));
        equalBtn.setOnClickListener(v -> calculator.operation(ACTIONS.ACTION_EQUAL));
    }
}
