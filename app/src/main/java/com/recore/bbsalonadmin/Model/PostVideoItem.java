package com.recore.bbsalonadmin.Model;

import com.google.firebase.database.ServerValue;

public class PostVideoItem {

    private String videoURL;
    private Object timeStamp;
    private String contentType;
    private String title;
    private String description;
    private String postKey;
    private String userId;
    private String likesCounter;
    private String commentCounter;

    public PostVideoItem() {
    }

    public PostVideoItem(String videoURL, Object timeStamp, String contentType, String title, String description, String postKey, String userId, String likesCounter, String commentCounter) {
        this.videoURL = videoURL;
        this.timeStamp = ServerValue.TIMESTAMP;
        this.contentType = contentType;
        this.title = title;
        this.description = description;
        this.postKey = postKey;
        this.userId = userId;
        this.likesCounter = likesCounter;
        this.commentCounter = commentCounter;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getLikesCounter() {
        return likesCounter;
    }

    public void setLikesCounter(String likesCounter) {
        this.likesCounter = likesCounter;
    }

    public String getCommentCounter() {
        return commentCounter;
    }

    public void setCommentCounter(String commentCounter) {
        this.commentCounter = commentCounter;
    }
}
