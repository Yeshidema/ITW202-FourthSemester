package com.example.todo_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String Log_Tag = "TODO_7";
    public static final String Count = "CurrentCount";
    private TextView mShowCount;
    private Button mIncrement;
    private int mCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","onCreate");

        mShowCount = findViewById(R.id.ShowCount);
        mIncrement  = findViewById(R.id.button);

        mIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Increment();
            }

        });



        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("Count");
            mShowCount.setText(Integer.toString(mCount));
        }


        
    }

    public void Increment() {
        mCount++;
        mShowCount.setText(Integer.toString(mCount));
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("MainActivity","onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("MainActivity","onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d("MainActivity", "onPause");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d("MainActivity","onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("MainActivity","onDestroy");
    }

    @Override
    protected  void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("Count", mCount);
    }
}