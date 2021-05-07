package com.example.todo_12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.todo_12.MESSAGE";
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.order:
                Intent intent = new Intent(MainActivity.this, Order.class);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                return true;

            case R.id.status:
                displayToast("You have selected Status");
                return true;

            case R.id.favourites:
                displayToast("You have selected favourites");
                return true;

            case R.id.contacts:
                displayToast("You have selected contacts");
                return true;
        }
        return super.onOptionsItemSelected(item);
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