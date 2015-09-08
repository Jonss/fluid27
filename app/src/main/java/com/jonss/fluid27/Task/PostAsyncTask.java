package com.jonss.fluid27.Task;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.jonss.fluid27.model.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by neuromancer on 02/09/15.
 */
public class PostAsyncTask extends AsyncTask<Object, Object, List<Post>> {

    private static String URL_JSON = "http://fluid-challenge.herokuapp.com/posts/json";
    private static List<Post> posts = new ArrayList<>();

    @Override
    protected List<Post> doInBackground(Object... params) {
        posts.clear();
        JSONArray jsonArray;
        try {
            StringBuilder builder = getJsonFromAPI();
            jsonArray = new JSONArray(builder.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Post post = postFromJsonArray(jsonObject);
                posts.add(post);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @NonNull
    private StringBuilder getJsonFromAPI() {
        StringBuilder builder = null;
        URL url;
        try {
            url = new URL(URL_JSON);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = connection.getInputStream();
            Scanner scanner = new Scanner(inputStream);

            builder = new StringBuilder();
            while (scanner.hasNext()) {
                builder.append(scanner.nextLine());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder;
    }

    @NonNull
    private Post postFromJsonArray(JSONObject jsonPost) {
        Post post = null;
        try {
            long id = jsonPost.getLong("id");
            String userName = jsonPost.getString("user_name");
            String avatar = jsonPost.getString("avatar");
            String content = jsonPost.getString("content");
            String imageUrl = jsonPost.getString("image_url");
            post = new Post(id, userName, avatar, content, imageUrl);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return post;
    }


}