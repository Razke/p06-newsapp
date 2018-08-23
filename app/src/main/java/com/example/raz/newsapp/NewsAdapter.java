package com.example.raz.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {
    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param news    is the list of news, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the news at the given position
     * in the list of news.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }
        // Find the news at the given position in the list of news
        News currentNews = getItem(position);

        TextView titleView = listItemView.findViewById(R.id.title);
        // Display the title of the current news in that TextView
        titleView.setText(currentNews.getTitle());

        TextView sectionView = listItemView.findViewById(R.id.section);
        // Display the date of the current news in that TextView
        sectionView.setText(currentNews.getSection());

        TextView dateView = listItemView.findViewById(R.id.date);
        // Display the date of the current news in that TextView
        dateView.setText(currentNews.getDate());

        TextView authorView = listItemView.findViewById(R.id.author);
        // Display the author of the current news in that TextView
        authorView.setText(currentNews.getAuthor());

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}