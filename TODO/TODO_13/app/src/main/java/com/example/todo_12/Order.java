package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Order extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView textView;
    private Spinner spinner;
    private String Message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        textView = findViewById(R.id.textView4);
        spinner = findViewById(R.id.spinner);

        Intent intent = getIntent();
      String message =   intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
      textView.setText(message);
      

      if(spinner != null){
          spinner.setOnItemSelectedListener(this);
      }


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_label,
                android.R.layout.simple_spinner_dropdown_item);
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

      if(spinner != null){
          spinner.setAdapter(adapter);
      }


    }

    /*@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String SpinnerMessage = parent.getItemAtPosition(position).toString();
            displayToast(SpinnerMessage);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), Message,
                Toast.LENGTH_SHORT).show();
    }

    public void onRadioChecked(View view) {
        boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId()) {

            case R.id.SameDay:
            Message = getString(R.string.sameDay);
            displayToast(Message);
            break;

            case R.id.NextDay:
                Message = getString(R.string.nextDay);
                displayToast(Message);
                break;

            case R.id.PickUp:
                Message = getString(R.string.pickup);
                displayToast(Message);
                break;

            default:
                break;


        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String SpinnerMessage = parent.getItemAtPosition(position).toString();
        displayToast(SpinnerMessage);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}