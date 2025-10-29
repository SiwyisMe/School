package com.siwy.zad5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "SettingsPrefs";

    private EditText nameInput;
    private Switch notificationsSwitch;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        nameInput = findViewById(R.id.nameInput);
        notificationsSwitch = findViewById(R.id.notificationsSwitch);
        saveButton = findViewById(R.id.saveButton);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        nameInput.setText(prefs.getString("UserName", ""));
        notificationsSwitch.setChecked(prefs.getBoolean("NotificationsEnabled", false));

        saveButton.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("UserName", nameInput.getText().toString());
            editor.putBoolean("NotificationsEnabled", notificationsSwitch.isChecked());
            editor.apply();
            Toast.makeText(this, "Ustawienia zapisane!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
