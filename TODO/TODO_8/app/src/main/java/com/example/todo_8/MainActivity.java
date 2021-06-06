package com.example.todo_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_Tag = "bt.edu.rub.todo_08";
    private EditText mWebsite;
    private EditText mLocation;
    private EditText mShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsite = findViewById(R.id.Website);
        mLocation = findViewById(R.id.Location);
        mShare = findViewById(R.id.Share);
    }

    public void OpenWebsite(View view) {
        String msg = mWebsite.getText().toString();
        Uri url = Uri.parse( msg);
        Intent intent = new Intent(Intent.ACTION_VIEW, url);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else {
            Log.d("Implicit Intent", "Cannot find the intent");
        }

    }

    public void OpenLocation(View view) {
        String msg = mLocation.getText().toString();
        Uri location = Uri.parse("geo:0,0?q=" + msg);
        Intent intent = new Intent(Intent.ACTION_VIEW, location);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else
        {
            Log.d("Intent Implicit", "Cannot find intent");
        }
    }

    public void OpenShare(View view) {
        String msg = mShare.getText().toString();
        Uri text = Uri.parse(msg);
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
                .setText(msg)
                .setChooserTitle("Share this text with")
                .startChooser();

        Intent intent = new Intent(Intent.ACTION_SEND, text);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("Intent implicit", "Cannot find intent");
        }

    }
}