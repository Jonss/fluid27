package com.jonss.fluid27.layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.jonss.fluid27.R;
import com.jonss.fluid27.model.Post;

import java.util.List;

import static com.bumptech.glide.load.engine.DiskCacheStrategy.RESULT;

/**
 * Created by neuromancer on 30/08/15.
 */
public class PostAdapter extends BaseAdapter {

    private List<Post> posts;
    private Context context;

    public PostAdapter(List<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return posts.get(position).getId();
    }

    @Override

    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        Post post = posts.get(position);

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.post, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.userNameText.setText(post.getUserName());
        holder.postContentText.setText(post.getContent());

        Glide.with(context).load(post.getImageUrl())
                .diskCacheStrategy(RESULT)
                .into(holder.postImage);

        Glide.with(context).load(post.getAvatarUrl())
                .error(R.mipmap.fluid)
                .diskCacheStrategy(RESULT)
                .into(holder.userAvatar);

        return view;
    }
}
