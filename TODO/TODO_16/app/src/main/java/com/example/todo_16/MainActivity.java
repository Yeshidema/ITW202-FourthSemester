package com.example.todo_16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mList = new LinkedList<>();
    private WordListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i<20; i++){
            mList.addLast("Word " + i);
        }

        RecyclerView recyclerView = findViewById(R.id.recycleView);
        mAdapter = new WordListAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wordListSize = mList.size();
                // add a new word to the wordlist.
                mList.addLast("+ word " + wordListSize);

                // notify the adapter , that data has changed.
                recyclerView.getAdapter().notifyItemInserted(wordListSize);

                // scroll to the bottom
                recyclerView.smoothScrollToPosition(wordListSize);

            }
        });



    }
}