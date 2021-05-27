package com.example.todo_22;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mAuthor, mBook;
    private EditText mBookInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuthor = findViewById(R.id.authorText);
        mBook = findViewById(R.id.titleText);
        mBookInput = findViewById(R.id.EnterTitle);


    }

    public void searchBooks(View view) {
        String queryString = mBookInput.getText().toString();


//to check whether there is interent conneection
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if(connMgr != null){
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        if(networkInfo != null && networkInfo.isConnected()
                && queryString.length() != 0) {
            new FetchBook(mBook, mAuthor).execute(queryString);
            mAuthor.setText(" ");
            mBook.setText("Loading...");
        }
        else {
            if(queryString.length() == 0) {
                mAuthor.setText(" ");
                mBook.setText("No such books");
            }
            else{
                mAuthor.setText(" ");
                mBook.setText("No Network");
            }
        }

    }
}