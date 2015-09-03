package com.jonss.fluid27.actitities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.jonss.fluid27.Layout.PostAdapter;
import com.jonss.fluid27.R;
import com.jonss.fluid27.Task.PostAsyncTask;
import com.jonss.fluid27.model.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private List<Post> posts = new ArrayList<>();
    private ListView postsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            String json = new PostAsyncTask().execute().get();
            posts = createPosts(json);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        setPostsOnView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setPostsOnView();
    }

    public List<Post> createPosts(String line) {
        try {
            JSONArray jsonArray = new JSONArray(line);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonPost = jsonArray.getJSONObject(i);
                long id = jsonPost.getLong("id");
                String userName = jsonPost.getString("user_name");
                String avatar = jsonPost.getString("avatar");
                String content = jsonPost.getString("content");
                String imageUrl = jsonPost.getString("image_url");
                Post post = new Post(id, userName, avatar, content, imageUrl);
                posts.add(post);
            }
            return posts;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setPostsOnView() {
        postsListView = (ListView) findViewById(R.id.posts_list_view);
        PostAdapter postAdapter = new PostAdapter(posts, this);
        postsListView.setAdapter(postAdapter);
    }
}
