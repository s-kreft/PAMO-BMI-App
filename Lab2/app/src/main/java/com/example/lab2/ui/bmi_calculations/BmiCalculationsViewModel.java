package com.example.lab2.ui.bmi_calculations;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BmiCalculationsViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public BmiCalculationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is bmi fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

