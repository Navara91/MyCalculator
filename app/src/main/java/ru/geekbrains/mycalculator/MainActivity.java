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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация класса logic и передача в него ссылки на класс MainActivity,
        // чтобы можно было в нём пользоваться элементами макета "activity_main"
        // В этом методе MainActivity создана, поэтому в качестве this будет передан MainActivity,
        // а не null
        calculator = new Calculator(this);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(COUNTER_KEY, calculator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculator = savedInstanceState.getParcelable(COUNTER_KEY);
        calculator.showResult();
    }
}