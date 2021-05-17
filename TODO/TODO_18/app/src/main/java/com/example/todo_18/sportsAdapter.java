package com.example.todo_18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class sportsAdapter extends RecyclerView.Adapter<sportsAdapter.ViewHolder> {
    private ArrayList<Sport> mSportsData;
    private Context context;


    sportsAdapter(Context context, ArrayList<Sport> sportsData) {
        this.mSportsData = sportsData;
        this.context = context;
    }


    @NonNull
    @Override
    public sportsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context)
        .inflate(R.layout.list_item, parent, false));
        //Linking with xml file that is list_item
    }

    @Override
    public void onBindViewHolder(@NonNull sportsAdapter.ViewHolder holder, int position) {
            Sport currentSport = mSportsData.get(position);
            holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mSportsData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageButton mSportsImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subtitle);
            mSportsImage = itemView.findViewById(R.id.sportsImage);
        }

        void bindTo(Sport currentSport){
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());
            Glide.with(context).load(currentSport.getImageResource()).into(mSportsImage);
        }
    }

}
