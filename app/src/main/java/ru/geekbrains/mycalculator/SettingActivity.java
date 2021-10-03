package ru.geekbrains.mycalculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class SettingActivity extends AppCompatActivity {

    // Имя настроек
    private static final String NameSharedPreference = "CHANGE_THEME";
    private static final String AppTheme = "APP_THEME";


    private Constants.THEMES currentTheme;
    protected static final int CODE_OF_LIGHT_THEME = 0;
    protected static final int CODE_OF_DARK_THEME = 1;

    private SwitchMaterial switchForTheme;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.AppTheme));
        setContentView(R.layout.activity_setting);

        initThemeChooser();
    }

    private void initThemeChooser(){
        initSwitch(findViewById(R.id.switch_change_theme), CODE_OF_LIGHT_THEME);
        initSwitch(findViewById(R.id.switch_change_theme), CODE_OF_DARK_THEME);
    }

    private void initSwitch(View switchView, final int codeStyle){
        switchView.setOnClickListener(v -> {
            setAppTheme(codeStyle);
            recreate();
        });
    }

    private int getAppTheme(int codeStyle){
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private int getCodeStyle(int codeStyle){
        sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(AppTheme, codeStyle);
    }

    private void setAppTheme(int codeStyle){
        sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyle).apply();
    }

    private int codeStyleToStyleId(int codeStyle){
        switch (codeStyle){
            case CODE_OF_LIGHT_THEME:
                return R.style.AppTheme_LightTheme;
            case CODE_OF_DARK_THEME:
                return R.style.AppTheme_DarkTheme;
            default:
                return R.style.AppTheme;
        }
    }
}