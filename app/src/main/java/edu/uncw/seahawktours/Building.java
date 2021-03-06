package edu.uncw.seahawktours;


import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Building {

    @Id private long id;

    private String name;
    private String imageResourceString;
    private String caption;
    private String description;
    private String url;
    private double latitude;
    private double longitude;


    public Building(){}

    public Building(String name, String imageResourceString, String caption, String description, String url, double latitude, double longitude) {
        this.name = name;
        this.imageResourceString = imageResourceString;
        this.caption = caption;
        this.description = description;
        this.url = url;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public String getImageResourceString() {
        return imageResourceString;
    }

    public String getCaption() {
        return caption;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}