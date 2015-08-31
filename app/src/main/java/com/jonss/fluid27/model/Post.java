package com.jonss.fluid27.model;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return getImageUrl() + " " + getUserName() + " " + getContent() + " " + getAvatar();
    }

    public long getId() {
        return id;
    }
}
