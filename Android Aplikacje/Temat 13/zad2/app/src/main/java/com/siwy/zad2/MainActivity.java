package com.siwy.zad2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "SwitchPrefs";
    private static final String SWITCH_KEY = "SwitchState";

    private Switch mySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySwitch = findViewById(R.id.mySwitch);

        // --- Wczytaj zapisany stan ---
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean switchState = prefs.getBoolean(SWITCH_KEY, false);
        mySwitch.setChecked(switchState);

        // --- Zapisuj stan przy każdej zmianie ---
        mySwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
            editor.putBoolean(SWITCH_KEY, isChecked);
            editor.apply();
        });
    }
}