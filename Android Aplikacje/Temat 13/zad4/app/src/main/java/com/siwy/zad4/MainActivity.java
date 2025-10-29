package com.siwy.zad4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "BMIPrefs";
    private static final String WEIGHT_KEY = "Weight";
    private static final String HEIGHT_KEY = "Height";

    private EditText weightInput, heightInput;
    private TextView resultText;
    private Button calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        resultText = findViewById(R.id.resultText);
        calculateBtn = findViewById(R.id.calculateBtn);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        weightInput.setText(prefs.getString(WEIGHT_KEY, ""));
        heightInput.setText(prefs.getString(HEIGHT_KEY, ""));

        calculateBtn.setOnClickListener(v -> {
            double weight = Double.parseDouble(weightInput.getText().toString());
            double height = Double.parseDouble(heightInput.getText().toString()) / 100;
            double bmi = weight / (height * height);

            resultText.setText("Twoje BMI: " + String.format("%.2f", bmi));

            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(WEIGHT_KEY, weightInput.getText().toString());
            editor.putString(HEIGHT_KEY, heightInput.getText().toString());
            editor.apply();
        });
    }
}
