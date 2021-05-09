package com.example.todo_14iii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickDatePicker(View view) {

            DialogFragment newFragment = new DatePickerFragment();
            newFragment.show(getSupportFragmentManager(), "datePicker");

        }
        public void processDatePickerResult ( int year, int month, int dayOfMonth){
            String Month = Integer.toString(month + 1);
            String String_Year = Integer.toString(year);
            String String_Day = Integer.toString(dayOfMonth);

            String date_message = (Month + "/" + String_Day + "/" + String_Year);
            Toast.makeText(this, "Date:" + date_message, Toast.LENGTH_SHORT).show();
        }
    }
