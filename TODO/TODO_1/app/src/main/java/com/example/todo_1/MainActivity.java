package com.example.todo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;

    private int data = 10;
    private TextView mShowCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.textView3);
    }

    @SuppressLint("SetTextI18n")
    public void ShowToast(View view) {
        Toast.makeText(MainActivity.this, "Hello Toast", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    public void CountUp(View view) {

        mCount++;
        if (mCount == data) {
            Toast toast = Toast.makeText(this, "Count = " + data + " ", Toast.LENGTH_LONG);
            toast.show();


        }
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));

        }
    }
}