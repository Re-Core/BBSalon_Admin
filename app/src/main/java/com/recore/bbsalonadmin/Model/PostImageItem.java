package com.recore.bbsalonadmin.Model;

import com.google.firebase.database.ServerValue;

public class PostImageItem {

    private String imgURL;
    private Object timeStamp;
    private String contentType;
    private String Title;
    private String description;
    private String postKey;
    private String userId;

    public PostImageItem() {
    }

    public PostImageItem(String imgURL, Object timeStamp, String contentType, String title, String description, String postKey, String userId) {
        this.imgURL = imgURL;
        this.timeStamp = ServerValue.TIMESTAMP;
        this.contentType = contentType;
        Title = title;
        this.description = description;
        this.postKey = postKey;
        this.userId = userId;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
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

    public Object getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Object timeStamp) {
        this.timeStamp = timeStamp;
    }
}
