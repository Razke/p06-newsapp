package com.example.raz.newsapp;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Helper methods related to requesting and receiving news data from The Guardian.
 */
public final class QueryUtils {

    /**
     * Tag for the log messages
     */
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils() {
    }

    /**
     * Query the The Guardian dataset and return a list of {@link News} objects.
     */
    public static List<News> fetchNewsData(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        // Extract relevant fields from the JSON response and create a list of {@link News}
        List<News> news = extractFeatureFromJson(jsonResponse);

        // Return the list of {@link News}
        return news;
    }

    /**
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the News JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    /**
     * Return a list of {@link News} objects that has been built up from
     * parsing the given JSON response.
     */
    private static List<News> extractFeatureFromJson(String storyJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(storyJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding news to
        List<News> news = new ArrayList<>();

        try {
            JSONObject baseJsonResponse = new JSONObject(storyJSON);
            JSONObject response = baseJsonResponse.getJSONObject("response");

            // Extract the JSONArray associated with the key called "results",
            // which represents a list of results (or news).
            JSONArray storyArray = response.getJSONArray("results");

            // For each story in the storyArray, create an {@link News} object
            for (int i = 0; i < storyArray.length(); i++) {

                // Get a single story at position i within the list of news
                JSONObject currentNews = storyArray.getJSONObject(i);

                String storyTitle = currentNews.getString("webTitle");
                String storySection = currentNews.getString("sectionName");
                String storyDate = currentNews.getString("webPublicationDate");
                String storyUrl = currentNews.getString("webUrl");
                JSONObject fieldsObject = currentNews.getJSONObject("fields");
                String storyAuthor = fieldsObject.getString("byline");
                String storyImage = fieldsObject.getString("thumbnail");

                SimpleDateFormat dateObject = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'", Locale.getDefault());
                Date formatDate = null;
                try {
                    formatDate = dateObject.parse(storyDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String storyDateFormat = formatDate(formatDate);

                News story = new News(storyTitle, storySection, storyDateFormat, storyUrl, storyAuthor, storyImage);

                news.add(story);
            }
        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the story JSON results", e);
        }
        // Return the list of news
        return news;
    }

    /**
     * Return the formatted date string from a Date object.
     */
    private static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy  hh:mm", Locale.getDefault());
        return dateFormat.format(date);
    }
}