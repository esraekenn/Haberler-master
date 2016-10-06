package com.pordiva.esraeken.haberler.model;

/**
 * Created by esraeken on 06/09/16.
 */

public class Data

{
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    private String title;
    private String excerpt;
    public Images images;
    public category category;

    public Images getImages() {
        return images;
    }
    public category getCategory(){return category;}

    public void setImages(Images images) {
        this.images = images;
    }
}