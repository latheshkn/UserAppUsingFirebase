package com.example.cabuserapp;

public class Upload {


    private String Name;
    private String Image;

    public Upload() {
        //empty constructor needed
    }

    public Upload( String name, String image) {

        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}

