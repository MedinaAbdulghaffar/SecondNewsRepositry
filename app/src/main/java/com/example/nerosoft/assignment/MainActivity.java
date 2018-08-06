package com.example.nerosoft.assignment;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.nerosoft.assignment.Adapters.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<NewsOne>> {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.news_lv);
        //listView.setDivider(null);

        //this is for managing our loader
        LoaderManager loaderManager = getSupportLoaderManager();
        //this is for initializing our loader and the first parameter
        loaderManager.initLoader(0, null, this).forceLoad();


    }
   /** boolean isConnected(){
        ConnectivityManager connectivityManager=new ConnectivityManager();

    }*/


    @Override
    //for creating an object of AsyncTask class

    public Loader<List<NewsOne>> onCreateLoader(int id, Bundle args) {
        // This is the object of AsyncTask class and then will be send to the onLoaderFinished method as a Parameter
        return new MovieAsyncTask(this);
    }

    @Override
    public void onLoadFinished(Loader<List<NewsOne>> loader, List<NewsOne> data) {
        NewsAdapter newsAdapter = new NewsAdapter(this, R.layout.layout_list, (ArrayList<NewsOne>) data);
        gridView.setAdapter(newsAdapter);

    }

    //When the loading finishes this method will be called
    @Override
    public void onLoaderReset(Loader<List<NewsOne>> loader) {

    }
}
