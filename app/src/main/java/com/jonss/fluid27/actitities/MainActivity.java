package com.jonss.fluid27.actitities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.jonss.fluid27.R;
import com.jonss.fluid27.connection.Connectivity;
import com.jonss.fluid27.layout.PostAdapter;
import com.jonss.fluid27.model.Post;
import com.jonss.fluid27.task.PostAsyncTask;

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

        if(Connectivity.isConnected(this)) {
            listAllPosts();
            this.swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
            swipe.setOnRefreshListener(this);
        } else {
            dialogIfOffline();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            Intent about = new Intent(this, AboutActivity.class);
            startActivity(about);
            return false;
        }
        return super.onOptionsItemSelected(item);
    }

    private void listAllPosts() {
        try {
            posts = new PostAsyncTask().execute().get();
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
        swipe.setColorSchemeColors(R.color.fluid_blue);
        swipe.setRefreshing(false);
        swipe.clearAnimation();
    }


    private void dialogIfOffline() {
        new AlertDialog.Builder(this)
                .setTitle("Erro")
                .setMessage("Houve um erro ao acessar o app, verifique sua conexão.")
                .setNegativeButton("Sair", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).show();
    }
}
