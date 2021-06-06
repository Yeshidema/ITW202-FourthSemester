package com.example.todo_21;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {
    private WeakReference<TextView> mTextView; //we use the weak reference because
    // the garbage collector will think that the async task
    //no work and will throw it away, consuming less memory

    public SimpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }
    @Override
    protected String doInBackground(Void... voids) {
//Generate a random number between 0 and 10
        Random r = new Random();
        int n =  r.nextInt(11);

        //MAke the task take long enough that we have
        //time to rotate the phone while it is running
        int s = n * 200;

        //sleep for a random amount of time(s)
        try{
            Thread.sleep(s);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        //Return the string result
        return "Awake at last after sleeping for " + s + "milliseconds!";
    }

    protected void onPostExecute(String result){ //we are taking here string because
        //doInbackground has sent String
        mTextView.get().setText(result); //after receiving the string
                //set it to the textview

    }
}
