package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Donut(View view) {
        Toast.makeText(this, "You ordered a Donut", Toast.LENGTH_LONG).show();
    }

    public void IceCream(View view) {
        Toast.makeText(this, "You ordered an IceCream", Toast.LENGTH_LONG).show();
    }

    public void Froyo(View view) {
        Toast.makeText(this, "You ordered a FroYo", Toast.LENGTH_LONG).show();
    }

    public void Phone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData( Uri.parse("tel:77845557"));
        startActivity(intent);
    }
}