package com.example.pamo_bmi_app;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance();


    private double weightValue = 0.0;
    private double heightValue = 0.0;
    private TextView weightTextView;
    private TextView heightTextView;
    private TextView bmiTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        weightTextView = (TextView) findViewById(R.id.weightTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        bmiTextView = (TextView) findViewById(R.id.bmiTextView);
        EditText weightEditText = (EditText) findViewById(R.id.weightTextView);
        weightEditText.addTextChangedListener(weightEditTextWatcher);

        EditText heightEditText = (EditText) findViewById(R.id.heightTextView);
        heightEditText.addTextChangedListener(heightEditTextWatcher);
    }
    private void calculate() {
        double bmiValue = (weightValue / Math.sqrt(heightValue));

        bmiTextView.setText(numberFormat.format(bmiValue));
    }

    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                weightTextView.setText(numberFormat.format(weightValue));
            }
            catch (NumberFormatException e) {
                weightTextView.setText("");
                weightValue = 0.0;
            }
            calculate();
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };
    private final TextWatcher heightEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                heightTextView.setText(numberFormat.format(heightValue));
            }
            catch (NumberFormatException e) {
                heightTextView.setText("");
                heightValue= 0.0;
            }
            calculate();
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}