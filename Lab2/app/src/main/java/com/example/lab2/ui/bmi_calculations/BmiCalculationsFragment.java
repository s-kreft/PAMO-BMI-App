package com.example.lab2.ui.bmi_calculations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab2.databinding.FragmentBmiCalculationsBinding;
import com.example.lab2.databinding.FragmentDashboardBinding;
import com.example.lab2.ui.dashboard.DashboardViewModel;

public class BmiCalculationsFragment extends Fragment {
    private FragmentBmiCalculationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BmiCalculationsViewModel bmiCalculationsViewModel =
                new ViewModelProvider(this).get(BmiCalculationsViewModel.class);

        binding = FragmentBmiCalculationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textBmi;
        bmiCalculationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
