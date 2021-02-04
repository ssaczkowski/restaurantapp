package com.ssaczkowski.restaurantlistapp;

public class Restaurant {
    private String name;
    private String urlPhoto;
    private float punctuation;
    private String direction;

    public Restaurant(String name, String urlPhoto, float punctuation, String direction) {
        this.name = name;
        this.urlPhoto = urlPhoto;
        this.punctuation = punctuation;
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public float getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(float punctuation) {
        this.punctuation = punctuation;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
