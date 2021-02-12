package com.example.tyuumon.beans;

import android.graphics.Bitmap;

public class MenuItem {
    private int id;
    private String name;
    private String img;
    private int count;
    private String price;
    private String description,action;
    private Bitmap bitmap;

    public MenuItem(){

    }

    public MenuItem(int id, String name, String img_url, int count, String price, String description, String action) {
        this.id = id;
        this.name = name;
        this.img = img_url;
        this.count = count;
        this.price = price;
        this.description = description;
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", count=" + count +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", action='" + action + '\'' +
                '}';
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
