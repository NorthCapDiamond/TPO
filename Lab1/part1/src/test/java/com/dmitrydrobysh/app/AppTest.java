package com.dmitrydrobysh.app;

import static org.junit.Assert.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.Test;
import static com.dmitrydrobysh.app.App.*;
import java.lang.Math;


public class AppTest {
    
    @ParameterizedTest
    @ValueSource(doubles = {1/2d, -1/2d, 0.9, -0.9})
    public void basic(double x) throws InvalidOperandException{
        assertEquals(Math.acos(x), taylorAcos(x, 7l), 0.01);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 1, -1})
    public void edges(double x) throws InvalidOperandException{
        assertEquals(Math.acos(x), taylorAcos(x, 7l), 0.01);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -2, -1})
    public void lowN(int n) throws InvalidOperandException{
        boolean exceptionIsThrown1 = false;
        try{
            taylorAcos(0, n);
        } catch (InvalidOperandException e) {
            exceptionIsThrown1 = true;
        }
        assertTrue(exceptionIsThrown1);
    }

    @ParameterizedTest
    @ValueSource(doubles = {2, -2})
    public void xOutOfRange(double x){
        boolean exceptionIsThrown1 = false;
        try{
            taylorAcos(x, 0);
        } catch (InvalidOperandException e) {
            exceptionIsThrown1 = true;
        }
        assertTrue(exceptionIsThrown1);
    }
}