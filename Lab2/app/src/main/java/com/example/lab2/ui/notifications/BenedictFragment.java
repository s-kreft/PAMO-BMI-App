package com.example.lab2.ui.notifications;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.Nullable;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab2.databinding.FragmentBenedictBinding;
import com.example.lab2.R;

import java.text.NumberFormat;


public class BenedictFragment extends Fragment {

    private FragmentBenedictBinding binding;

    private TextView bmiTextView;

    private static final NumberFormat numberFormat =
            NumberFormat.getNumberInstance();

    private EditText weightEditText;
    private EditText heightEditText;

    private EditText AgeEditText;

    private Switch genderSwitch;

    private Boolean isWoman = true;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BenedictViewModel notificationsViewModel =
                new ViewModelProvider(this).get(BenedictViewModel.class);

        binding = FragmentBenedictBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bmiTextView = (TextView) getView().findViewById(R.id.bmiTextView);
        bmiTextView = (TextView) getView().findViewById(R.id.bmiTextView);

        heightEditText =
                (EditText) getView().findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(valueChangedTextWatcher);

        weightEditText =
                (EditText) getView().findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(valueChangedTextWatcher);

        AgeEditText = (EditText) getView().findViewById(R.id.AgeEditText);
        AgeEditText.addTextChangedListener(valueChangedTextWatcher);

        genderSwitch = (Switch) getView().findViewById(R.id.switchGender);
        genderSwitch.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isWoman = isChecked;
                calculate();
            }
        }));
    }

    private void calculate() {
        String heightString = heightEditText.getText().toString();
        String weightString = weightEditText.getText().toString();
        String ageString = AgeEditText.getText().toString();
        if (!heightString.isEmpty() && !weightString.isEmpty() && !ageString.isEmpty())
        {
            double height = Double.parseDouble(heightString);
            double weight = Double.parseDouble(weightString);
            int age = Integer.parseInt(ageString);
            double bmi = 0;
            if (isWoman) {
//                bmi = weight / Math.pow(height, 2);
                bmi = 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);
            }
            else {
                bmi = 66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age);
            }
            bmiTextView.setText(numberFormat.format(bmi));
        }
    }

    private final TextWatcher valueChangedTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}