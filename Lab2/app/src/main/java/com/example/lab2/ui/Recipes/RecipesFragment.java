package com.example.lab2.ui.Recipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab2.databinding.FragmentRecipesBinding;

public class RecipesFragment extends Fragment {

    private FragmentRecipesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RecipesViewModel dashboardViewModel =
                new ViewModelProvider(this).get(RecipesViewModel.class);

        binding = FragmentRecipesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}