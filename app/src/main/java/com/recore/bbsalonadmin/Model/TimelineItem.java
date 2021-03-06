package com.recore.bbsalonadmin.Model;


import com.recore.bbsalonadmin.Common.Constant;

public class TimelineItem {

    private HeaderTextItem headerTextItem;
    private PostVideoItem postVideoItem;
    private PostImageItem postImageItem;

    private int viewType;

    public TimelineItem(HeaderTextItem headerTextItem) {
        this.headerTextItem = headerTextItem;
        viewType = Constant.ITEM_HEADER_TEXT_VIEWTYPE;
    }



    public TimelineItem(PostVideoItem postVideoItem) {
        this.postVideoItem = postVideoItem;
        viewType = Constant.ITEM_HEADER_POST_VIDEO_VIEWTYPE;
    }

    public TimelineItem(PostImageItem postImageItem) {
        this.postImageItem = postImageItem;
        viewType = Constant.ITEM_HEADER_POST_IMAGE_VIEWTYPE;
    }

    public HeaderTextItem getHeaderTextItem() {
        return headerTextItem;
    }

    public void setHeaderTextItem(HeaderTextItem headerTextItem) {
        this.headerTextItem = headerTextItem;
    }


    public PostVideoItem getPostVideoItem() {
        return postVideoItem;
    }

    public void setPostVideoItem(PostVideoItem postVideoItem) {
        this.postVideoItem = postVideoItem;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public PostImageItem getPostImageItem() {
        return postImageItem;
    }

    public void setPostImageItem(PostImageItem postImageItem) {
        this.postImageItem = postImageItem;
    }
}
