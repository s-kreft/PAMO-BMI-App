package com.example.pamo_bmi_app;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
        weightTextView.setText(numberFormat.format(0.0));
        heightTextView.setText(numberFormat.format(0.0));
        bmiTextView.setText(numberFormat.format(0.0));

        EditText weightEditText = (EditText) weightTextView;
        weightEditText.addTextChangedListener(weightEditTextWatcher);

        EditText heightEditText = (EditText) heightTextView;
        heightEditText.addTextChangedListener(heightEditTextWatcher);
    }
    private void calculate() {
        try {
            double exponent = 2;
            double bmiValue = (weightValue / Math.pow(heightValue, exponent));
            bmiTextView.setText(numberFormat.format(bmiValue));
        }
        catch (Exception ex)
        {
            Log.e("x", ex.getMessage());
        }
    }


    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                String text = s.toString();
                weightValue = Double.parseDouble(text);
                calculate();
            }
            catch (Exception ex) {
                Log.e("x", ex.getMessage());
            }
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
                String text = s.toString();
                heightValue = Double.parseDouble(text);
                calculate();
            }
            catch (Exception ex) {
                Log.e("x", ex.getMessage());
            }
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}