package com.jonss.fluid27;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.jonss.fluid27.model.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private List<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream inputStream = this.getResources().openRawResource(R.raw.arquivo);

        Scanner scanner = new Scanner(inputStream);
        StringBuilder builder = new StringBuilder();
        while(scanner.hasNext()) {
            builder.append(scanner.nextLine());
        }

        posts = createPosts(builder.toString());


        for (Post post: posts) {
            Log.d("Post", post.getEmail() + " ==== " + post.getName());
        }
    }



    public List<Post> createPosts(String line) {
        try {
            JSONObject json = new JSONObject(line);
            JSONArray jsonArray = json.getJSONArray("posts");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonPost = jsonArray.getJSONObject(i);
                Post post = new Post();
                post.setEmail(jsonPost.getString("email"));
                post.setName(jsonPost.getString("name"));
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
}
