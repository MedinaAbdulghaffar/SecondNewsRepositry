package com.example.nerosoft.assignment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MovieAsyncTask extends AsyncTaskLoader<List<NewsOne>> {
    String url = "https://api.themoviedb.org/3/movie/popular?api_key=f102a1dcbc12ebc56bc08a84cba950ba&language=en-US&page=1";
    List<NewsOne> arrayListOfNews = new ArrayList<>();

    public MovieAsyncTask(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public List<NewsOne> loadInBackground() {
        URL url1 = null;
        try {
            url1 = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        StringBuilder jsonData = new StringBuilder();
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;

        try {
            httpURLConnection = (HttpURLConnection) url1.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader read = new BufferedReader(inputStreamReader);
            String line = read.readLine();
            while (line != null) {
                jsonData.append(line);
                line = read.readLine();
            }


        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


       /* try {
            //the root of the json is object that is why we create the object of JSONObject if the root of the JSON was Array then we will create an object of JSONArray insted
            JSONObject root = new JSONObject(jsonData.toString());// this is an object for getting our API we added in our class JSON if we want to use our class in android studio but here we will access it directly from the internet that is more better to get updated data
            JSONArray results = root.getJSONArray("results");// this is for getting the Array of results in the API


            String title;
            //String author;
            String image;

            for (int i = 0; i < results.length(); i++) {

                JSONObject element = results.getJSONObject(i);// this is for getting each index in the Array of articles in the API
                title = element.getString("title");// the parameter is the strings we have in the objects in the array of API
                // author = element.getString("author");//the parameter is the strings we have in the objects in the array of API
                image = element.getString("poster_path");//the parameter is the strings we have in the objects in the array of API
                arrayListOfNews.add(new News(null, title, image));

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }*/
       Gson gson=new Gson();
       Root root=gson.fromJson(jsonData.toString(),Root.class);
        if (root != null) {
            if (root.getResults()!=null)
            {
                arrayListOfNews=root.getResults();
            }
        }
        return arrayListOfNews;
    }
}









