package com.example.test.domain.model;

public class SportNew {

    String imgUrl;
    String title;
    String description;
    String readTime;
    int views;

    public SportNew(String imgUrl, String title, String description, String readTime, int views) {
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
