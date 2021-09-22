package ru.geekbrains.mycalculator;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String COUNTER_KEY = "COUNTER_KEY";
    // Основной класс, реализующий логику калькулятора (здесь он создаётся, но не инициализируется,
    // потому что здесь ещё MainActivity не создана
    private Calculator calculator;

    TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация класса logic и передача в него ссылки на класс MainActivity,
        // чтобы можно было в нём пользоваться элементами макета "activity_main"
        // В этом методе MainActivity создана, поэтому в качестве this будет передан MainActivity,
        // а не null
        if (savedInstanceState == null) {
            calculator = new Calculator(this);
        } else {
            resultTv = findViewById(R.id.result_tv);
            calculator = savedInstanceState.getParcelable(COUNTER_KEY);
            calculator.showResult(resultTv);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(COUNTER_KEY, calculator);
        super.onSaveInstanceState(outState);
    }

/*    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        calculator = savedInstanceState.getParcelable(COUNTER_KEY);
        super.onRestoreInstanceState(savedInstanceState);
    }*/
}