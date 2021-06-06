package com.example.todo_9;

public class Calculator {

    public enum operator{Add, Sub, Mul, Div};

    public double Add(double Num1, double Num2){
        return Num1 + Num2;
    }

    public double Sub(double Num1, double Num2){
        return Num1 - Num2;
    }

    public double Mul(double Num1, double Num2){
        return Num1 * Num2;
    }

    public double Div(double Num1, double Num2){
        return Num1 / Num2;
    }
}
