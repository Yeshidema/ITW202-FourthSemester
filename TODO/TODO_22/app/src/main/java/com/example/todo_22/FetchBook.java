package com.example.todo_22;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class FetchBook extends AsyncTask<String, Void, String> {
    private WeakReference<TextView> mTitleText;
    private WeakReference<TextView> mAuthorText;

    FetchBook (TextView titleText, TextView authorText) {
        this.mTitleText = new WeakReference<>(titleText);
        this.mAuthorText = new WeakReference<>(authorText);
    }

    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getBookInfo(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        try{
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            int i = 0;
            String title = null;
            String authors = null;
            while (i < itemsArray.length() &&
                    (authors == null && title == null)) {
                //Get the current item information
                JSONObject book = itemsArray.getJSONObject(i);
                //get the volumeInfo because our author name and book name is in volumeInfo
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                        try{
                            title = volumeInfo.getString("title");
                            authors = volumeInfo.getString("authors");
                        }
            catch (Exception e){
                            e.printStackTrace();
            }
            //move to the next item
            i++;
            }
            //if both are found, display the data
            if (title != null && authors != null){
                //using get() here because we used weakreference earlier
                //so to dereference it , get() must be used
                mTitleText.get().setText(title);
                mAuthorText.get().setText(authors);
            }
            else{
                mTitleText.get().setText("No results found");
                mAuthorText.get().setText("");
            }


        }
        catch (JSONException e){
           mTitleText.get().setText("No results found");
           mAuthorText.get().setText(" ");
        }
        super.onPostExecute(s);
    }
}
