package com.example.todo_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public static final String REPLY_MESSAGE = "edu.gcit.TODO_4.MESSAGE";
    public static final String LogTag = "MyActivity";
    private TextView mTextMessage;
    private EditText mTypeSth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("MainActivity2","onCreate");

        Intent intent = getIntent();

        String message = intent.getStringExtra("EXTRA_MESSAGE");
        mTextMessage = findViewById(R.id.display_msg);
        mTextMessage.setText(message);
    }

    public void ReplyMessage(View view) {
        mTypeSth = findViewById(R.id.Reply_txt);
        String message = mTypeSth.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("REPLY_MESSAGE",message);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("MainActivity2","onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("MainActivity2","onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d("MainActivity2","onPause");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d("MainActivity2","onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("MainActivity2","onDestroy");
    }
}