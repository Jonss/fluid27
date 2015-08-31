package com.jonss.fluid27.Adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonss.fluid27.R;
import com.jonss.fluid27.model.Post;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by neuromancer on 30/08/15.
 */
public class PostAdapter extends BaseAdapter {

    private List<Post> posts;
    private Activity activity;

    public PostAdapter(List<Post> posts, Activity activity) {
        this.posts = posts;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.post, parent, false);
        Post post = posts.get(position);

        TextView userName = (TextView) view.findViewById(R.id.post_user_name);
        userName.setText(post.getUserName());

        TextView content = (TextView) view.findViewById(R.id.post_content);
        content.setText(post.getContent());

        return view;
    }

}
