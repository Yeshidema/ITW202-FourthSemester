package com.example.todo_23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //customized action, should be same as customreceiver
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + "com.example.todo_23.ACTION_CUSTOM_BROADCAST";
    private CustomReceiver mReceiver = new CustomReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create an object for intent filter to register the app(receiver) because
        //we are doing it dynamically
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);

        //register the receiver using the activity context
        this.registerReceiver(mReceiver, filter);

        //register the receiver for our customized receiver
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(mReceiver,
                        new IntentFilter(ACTION_CUSTOM_BROADCAST));

    }
    @Override
    protected void onDestroy() {
        //Unregister the receiver(system broadcast)
        //like charger
        this.unregisterReceiver(mReceiver);

        //unregister the customized receiver
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(mReceiver);
        super.onDestroy();
    }


    public void sendCustomBroadcast(View view) {
        //create a new intent with the action that we created
        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
        //send the broadcast using the localBroadcastManager class
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }
}