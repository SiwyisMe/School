package com.siwy.zad5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "SettingsPrefs";
    private TextView greetingText;
    private Button settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetingText = findViewById(R.id.greetingText);
        settingsButton = findViewById(R.id.settingsButton);

        loadGreeting();

        settingsButton.setOnClickListener(v -> {
            startActivity(new Intent(this, SettingsActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadGreeting();
    }

    private void loadGreeting() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String name = prefs.getString("UserName", "gościu");
        greetingText.setText("Witaj, " + name + "!");
    }
}
