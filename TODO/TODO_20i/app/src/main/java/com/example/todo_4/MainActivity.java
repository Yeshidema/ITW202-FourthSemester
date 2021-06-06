package com.example.todo_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "edu.gcit.TODO_4.MESSAGE";
    private EditText mTextMessage;
    private TextView mDisplayMessage;
    private TextView mReply;
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDisplayMessage = findViewById(R.id.Display_msg);
        mReply = findViewById(R.id.Replay_reached);
        




    }

    public void MessageReceived(View view) {
        mTextMessage = findViewById(R.id.editText);
        String message = mTextMessage.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("EXTRA_MESSAGE",message);
        startActivityForResult(intent,TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String message = intent.getStringExtra("REPLY_MESSAGE");
                mDisplayMessage.setText(message);
                mDisplayMessage.setVisibility(View.VISIBLE);
                mReply.setVisibility(View.VISIBLE);


            }
        }
    }
}