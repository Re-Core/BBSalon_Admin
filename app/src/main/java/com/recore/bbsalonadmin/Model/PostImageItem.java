package com.recore.bbsalonadmin.Model;

import com.google.firebase.database.ServerValue;

public class PostImageItem {

    private String imgURL;
    private String userImg;
    private Object timeStamp;
    private String contentType;
    private String Title;
    private String description;
    private String postKey;
    private String userId;

    public PostImageItem() {
    }

    public PostImageItem(String imgURL, String userImg, String contentType, String title, String description, String postKey, String userId) {
        this.imgURL = imgURL;
        this.userImg = userImg;
        this.contentType = contentType;
        Title = title;
        this.description = description;
        this.postKey = postKey;
        this.userId = userId;
        this.timeStamp = ServerValue.TIMESTAMP;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostKey() {
        return postKey;
    }

    public void setPostKey(String postKey) {
        this.postKey = postKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
