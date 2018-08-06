package com.example.nerosoft.assignment.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nerosoft.assignment.NewsOne;
import com.example.nerosoft.assignment.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<NewsOne> objects;
    PlaceHolder placeHolder;

    public NewsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<NewsOne> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(resource, parent, false);
            placeHolder = new PlaceHolder();
            placeHolder.newsImage = convertView.findViewById(R.id.news_iv);
            placeHolder.titleTextView = convertView.findViewById(R.id.title_tv);
           // placeHolder.authorTextView = convertView.findViewById(R.id.author_tv);
            convertView.setTag(placeHolder);
        } else {
            placeHolder = (PlaceHolder) convertView.getTag();
        }

        NewsOne news = objects.get(position);
       // placeHolder.authorTextView.setText(news.getAuthor());
        placeHolder.titleTextView.setText(news.getTitle());
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+news.getPosterPath()).into(placeHolder.newsImage);
       // Log.v("image", news.getImage());
        return convertView;
    }
}

class PlaceHolder {
    ImageView newsImage;
   // TextView authorTextView;
    TextView titleTextView;
}
