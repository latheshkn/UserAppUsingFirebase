package com.example.cabuserapp;

public class Modelclass {
    private int Age;
    private String Name;
    private String  Image;
    private  String Model;

    public Modelclass() {
    }

    public Modelclass(int age, String name, String image, String model) {
        Age = age;
        Name = name;
        Image = image;
        Model = model;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
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

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }
}
