package com.jonss.fluid27.layout;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonss.fluid27.R;

/**
 * Created by neuromancer on 31/08/15.
 */
public class ViewHolder {
    protected ImageView postImage;
    protected TextView postContentText;
    protected TextView userNameText;
    protected ImageView userAvatar;

    ViewHolder(View view) {
        this.postImage = (ImageView) view.findViewById(R.id.post_image);
        this.userAvatar = (ImageView) view.findViewById(R.id.post_avatar);
        this.userNameText = (TextView) view.findViewById(R.id.post_user_name);
        this.postContentText = (TextView) view.findViewById(R.id.post_content);
    }
}
