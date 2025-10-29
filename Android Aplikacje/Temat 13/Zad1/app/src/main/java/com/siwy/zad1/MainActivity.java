package com.siwy.zad1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String DATA_KEY = "UserInputData";

    private EditText dataInput;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataInput = findViewById(R.id.dataInput);
        saveButton = findViewById(R.id.saveButton);

        // --- Automatyczne wczytywanie danych ---
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String savedData = prefs.getString(DATA_KEY, "");
        dataInput.setText(savedData);

        // --- Zapis danych ---
        saveButton.setOnClickListener(v -> {
            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
            editor.putString(DATA_KEY, dataInput.getText().toString());
            editor.apply();
            Toast.makeText(this, "Dane zapisane!", Toast.LENGTH_SHORT).show();
        });
    }
}
