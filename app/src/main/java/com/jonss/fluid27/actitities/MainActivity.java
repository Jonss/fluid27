package com.jonss.fluid27.actitities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.jonss.fluid27.Layout.PostAdapter;
import com.jonss.fluid27.R;
import com.jonss.fluid27.Task.PostAsyncTask;
import com.jonss.fluid27.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private List<Post> posts = new ArrayList<>();
    private ListView postsListView;
    private SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listAllPosts();

        this.swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);

        swipe.setOnRefreshListener(this);

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

    private void listAllPosts() {
        try {
            posts =  new PostAsyncTask().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        setPostsOnView();
    }

    private void setPostsOnView() {
        postsListView = (ListView) findViewById(R.id.posts_list_view);
        PostAdapter postAdapter = new PostAdapter(posts, this);
        postsListView.setAdapter(postAdapter);
    }

    @Override
    public void onRefresh() {
        listAllPosts();

    }
}
