package com.example.test.data.model;

public class SportNewData {

    String imgUrl;
    String title;
    String description;
    String readTime;
    int views;

    public SportNewData(String imgUrl, String title, String description, String readTime, int views) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.description = description;
        this.readTime = readTime;
        this.views = views;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getReadTime() {
        return readTime;
    }

    public int getViews() {
        return views;
    }
}
