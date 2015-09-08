package com.jonss.fluid27.model;

import java.util.List;

/**
 * Created by neuromancer on 30/08/15.
 */
public class Post {
    private long id;
    private String userName;
    private String avatar;
    private String content;
    private String imageUrl;


    public Post(long id, String userName, String avatar, String content, String imageUrl) {
        this.id = id;
        this.userName = userName;
        this.avatar = avatar;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getAvatarUrl() {
        return avatar;
    }

    public String getContent() {
        return content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return getId() + " " + getImageUrl() + " " + getUserName() + " " + getContent() + " " + getAvatarUrl();
    }

}
