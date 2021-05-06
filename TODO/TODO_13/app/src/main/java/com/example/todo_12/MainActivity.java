package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.todo_12.MESSAGE";
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void Donut(View view) {

        message = getString(R.string.OrderDonut);
        displayToast(message);
    }

    public void IceCream(View view) {

        message = getString(R.string.OrderIceCream);
        displayToast(message);
    }

    public void Froyo(View view) {
        message = getString(R.string.OrderFroyo);
        displayToast(message);
    }

    public void Phone(View view) {
        Intent intent = new Intent(MainActivity.this, Order.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}