package com.siwy.zad3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "CounterPrefs";
    private static final String COUNT_KEY = "LaunchCount";

    private TextView counterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterText = findViewById(R.id.counterText);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int count = prefs.getInt(COUNT_KEY, 0);
        count++;

        counterText.setText("Aplikacja uruchomiona: " + count + " razy");

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(COUNT_KEY, count);
        editor.apply();
    }
}
