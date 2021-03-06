package com.example.mvvm_api.Model;

public class NicePlace {

    private String title;
    private int imageUrl;

    public NicePlace() {
    }

    public NicePlace(String title, int imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
