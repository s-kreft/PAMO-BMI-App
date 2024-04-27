package com.example.lab2.service;

public class BmiAppService {

    public BmiAppService() {

    }

    public double bmiCalculation(double weightValue, double heightValue) {
        double exponent = 2;
        return (weightValue / Math.pow(heightValue, exponent));
    }
}
