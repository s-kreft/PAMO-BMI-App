package com.example.lab2;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

import com.example.lab2.service.BmiAppService;
import com.example.lab2.ui.bmi_calculations.BmiCalculationsFragment;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BmiAppUnitTest {

    BmiAppService bmiCalculationTest = new BmiAppService();
    @Test
    @DisplayName("Ensure cerrect calculation of bmi value")
    public void bmiCalculateTest() {
        double weightValue = 85;
        double heightValue = 1.8;

        assertEquals(26.2, bmiCalculationTest.bmiCalculation(weightValue, heightValue), 0.1);
    }
}