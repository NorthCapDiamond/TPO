package com.dmitrydrobysh.app;

import java.lang.Math;
import java.io.IOException;
import java.util.Scanner;


public class App {

    private static long factorialLoop(long n, long accumulator){
        return (n <= 0) ? accumulator : factorialLoop(n-1, accumulator*n);
    }

    public static long factorial(long n) throws InvalidOperandException{
        if(n < 0){
            throw new InvalidOperandException("Number for factorial must be > 0\n");
        }
        return factorialLoop(n, 1);
    }

    public static double taylorAsin(double x, long n) throws InvalidOperandException{
        if(n <= 0){
            throw new InvalidOperandException("Amount of iterations must be > 0\n");
        }

        if(x < -1){
            throw new InvalidOperandException("X must be > -1\n");
        }

        if(x > 1){
            throw new InvalidOperandException("X must be < 1\n");
        }


        double answer = 0;

        double tmp = 1;

        for(long i = 0; i < n; i++){

            tmp = 1f;
            tmp*=(factorial(2*i));
            tmp/=(Math.pow(4, i));
            tmp/=(Math.pow(factorial(i), 2));
            tmp/=(2*i + 1);

            tmp*=(Math.pow(x, 2*i+1));
            answer += tmp;
        }

        return answer;
    }


    public static double taylorAcos(double x, long n) throws InvalidOperandException{
        double answer = Math.PI/2;
        return answer - taylorAsin(x, n);
    }


    public static void main(String ... args) throws InvalidOperandException{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your Double value and your long Value");
        double decimal = in.nextDouble();
        long longeger = in.nextLong();

        System.out.println(taylorAcos(decimal, longeger));
    }
}