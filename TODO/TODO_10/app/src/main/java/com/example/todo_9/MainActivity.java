package com.example.todo_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mNum1;
    private EditText mNum2;
    private  EditText mResult;
    private Calculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNum1 = findViewById(R.id.Num1);
        mNum2 = findViewById(R.id.Num2);
        mResult = findViewById(R.id.Result);

        mCalculator = new Calculator();
    }

    public void Add(View view) {
        String Operand1 = mNum1.getText().toString();
        String Operand2 = mNum2.getText().toString();

        double value = mCalculator.Add(Double.valueOf(Operand1), Double.valueOf(Operand2) );
        mResult.setText(String.valueOf(value));
    }

    public void Sub(View view) {
        String Operand1 = mNum1.getText().toString();
        String Operand2 = mNum2.getText().toString();

        double value = mCalculator.Sub(Double.valueOf(Operand1), Double.valueOf(Operand2) );
        mResult.setText(String.valueOf(value));

    }

    public void Mul(View view) {
        String Operand1 = mNum1.getText().toString();
        String Operand2 = mNum2.getText().toString();

        double value = mCalculator.Mul(Double.valueOf(Operand1), Double.valueOf(Operand2) );
        mResult.setText(String.valueOf(value));
    }

    public void Div(View view) {
        String Operand1 = mNum1.getText().toString();
        String Operand2 = mNum2.getText().toString();

        double value = mCalculator.Div(Double.valueOf(Operand1), Double.valueOf(Operand2) );
        mResult.setText(String.valueOf(value));
    }
}