package com.example.todo_22;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class NetworkUtils {
    private static final String LOG_TAG =
            NetworkUtils.class.getSimpleName();

    //Base url for Books API
    private static final String BOOK_BASE_URL = "https://www.googleapis.com/books/v1/volumes?";

    //parameter for the search string
    private static final String QUERY_PARAM = "q";

    //parameter that limits search results
    private static final String MAX_RESULTS = "maxResults";

    //parameter to filter by print type
    private static final String PRINT_TYPE = "printType";


    public static String getBookInfo(String queryString){
        HttpURLConnection urlConnection = null;

        BufferedReader reader = null;
        String bookJSONString = null;

        try{
            Uri builtURI = Uri.parse(BOOK_BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM, queryString)
                    .appendQueryParameter(MAX_RESULTS, "10")
                    .appendQueryParameter(PRINT_TYPE, "books")
                    .build();

            //converting Uri to string
            URL requestURL = new URL(builtURI.toString());

            //this 3 lines mean that you are now connected to an internet
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            //Get the inputStream
            InputStream inputStream = urlConnection.getInputStream();

            //create a buffered reader from that input stream. Our data is stored in reader after retrieving
            reader = new BufferedReader(new InputStreamReader(inputStream));

            //Use a stringbuilder to hold the incoming response
            StringBuilder builder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line); //data is now in builder as well

                builder.append("\n");
            }
            if(builder.length() == 0 ){
                return null;
            }
            //convert the data to string and store in bookJSONString
            bookJSONString = builder.toString();


        }  catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (urlConnection != null){
                urlConnection.disconnect();
            }
            if (reader != null){
                try {
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        Log.d(LOG_TAG, bookJSONString);
        //return bookJSONString where data is stored
        return bookJSONString;
    }
}
