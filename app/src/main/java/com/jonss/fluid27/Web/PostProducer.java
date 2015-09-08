package com.jonss.fluid27.Web;

import com.jonss.fluid27.model.Post;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by neuromancer on 08/09/15.
 */
public class PostProducer {

    public Post create(JSONObject jsonPost) {
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
