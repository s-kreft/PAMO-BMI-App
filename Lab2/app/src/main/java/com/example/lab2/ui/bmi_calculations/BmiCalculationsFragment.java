package com.example.lab2.ui.bmi_calculations;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab2.databinding.FragmentBmiCalculationsBinding;
import com.example.lab2.R;
import com.example.lab2.service.BmiAppService;


import java.text.NumberFormat;

public class BmiCalculationsFragment extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance();


    private double weightValue = 0.0;
    private double heightValue = 0.0;
    private TextView weightTextView;
    private TextView heightTextView;
    private TextView bmiTextView;

    private FragmentBmiCalculationsBinding binding;
     private BmiAppService bmiCalculationFormula = new BmiAppService();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BmiCalculationsViewModel bmiCalculationsViewModel =
                new ViewModelProvider(this).get(BmiCalculationsViewModel.class);

        binding = FragmentBmiCalculationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        weightTextView = (TextView) getView().findViewById(R.id.weightTextView);
        heightTextView = (TextView) getView().findViewById(R.id.heightTextView);
        bmiTextView = (TextView) getView().findViewById(R.id.bmiTextView);
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
            double bmiValue = bmiCalculationFormula.bmiCalculation(weightValue, heightValue);
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
