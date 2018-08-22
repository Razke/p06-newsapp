package com.example.raz.newsapp;

/**
 * An {@link News} object contains information related to single news.
 */
public class News {
    private String mTitle;
    private String mSection;
    private String mDate;
    private String mUrl;
    private String mAuthor;
    private String mImage;

    /**
     * Constructs a new {@link News} object.
     *
     * @param title   is the title of the news
     * @param section is the section of the news
     * @param date    is the date the news happened
     * @param url     is the url of the news
     * @param author  is the author of the news
     * @param image   is the thumbnail of the news
     */
    public News(String title, String section, String date, String url, String author, String image) {
        mTitle = title;
        mSection = section;
        mDate = date;
        mUrl = url;
        mAuthor = author;
        mImage = image;
    }

    /**
     * Returns the title of the news.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the section of news.
     */
    public String getSection() {
        return mSection;
    }

    /**
     * Returns the date of the news.
     */
    public String getDate() {
        return mDate;
    }

    /**
     * Returns the url of the news.
     */
    public String getUrl() {
        return mUrl;
    }

    /**
     * Returns the author of the news.
     */
    public String getAuthor() {
        return mAuthor;
    }

    /**
     * Returns the thumbnail of the news.
     */
    public String getImage() {
        return mImage;
    }
}