package com.example.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private  String [] array = {"cornFlowerBlue", "coral", "DarkCyan","DarkMagenta","DarkSlateBlue"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);

    }

    public void ChangeColor(View view) {
        Random random = new Random();
        String color = array[random.nextInt(5)];


        int ColorResource =  getResources().getIdentifier(color, "color",getApplicationContext().getPackageName());
       /*int ColorRes;
        ColorRes = getResources().getColor(ColorResource);*/

        int ColorRes = ContextCompat.getColor(this, ColorResource);
        mTextView.setTextColor(ColorRes);


    }
}