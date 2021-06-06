package com.example.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private sportsAdapter mAdapter;
    private ArrayList<Sport> mSportsData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the recycle view
        recyclerView = findViewById(R.id.recycleView);

        //set the layoutmanager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initialize the arraylist that will contain data
        mSportsData= new ArrayList<>();

        //initialize the adapter and set it to recycleview
        mAdapter = new sportsAdapter(this, mSportsData);
        recyclerView.setAdapter(mAdapter);

        //done with recycleview

        //get the data
        initializeData();

    }

    // methods for initializing the sports data from the resources
    private void initializeData() {

        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);
    String[] sportsList = getResources().getStringArray(R.array.sports_title);
    String[] sportsInfo = getResources().getStringArray(R.array.sports_info);

    //clear the existing data(to avoid the duplication)
        mSportsData.clear();

        //create the arraylist of sports objects with titles and information
        for(int i = 0; i<sportsList.length;i++){
            mSportsData.add(new Sport(sportsList[i], sportsInfo[i], sportsImageResources.getResourceId(i, 0)));
        }

        //Notify the change to the adapter
        mAdapter.notifyDataSetChanged();
        sportsImageResources.recycle(); //avoid duplication, works fine without it
    }
}