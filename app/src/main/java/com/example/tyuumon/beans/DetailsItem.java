package com.example.tyuumon.beans;

import android.graphics.Bitmap;

public class DetailsItem {
    private int id;
    private String name;
    private String img;
    private double originalprice;
    private int tPrice;
    private String price;
    private String description;
    private Bitmap bitmap;

    public DetailsItem(){

    }

    public DetailsItem(int id, String name, String img, double originalprice, int tPrice, String price, String description) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.originalprice = originalprice;
        this.tPrice = tPrice;
        this.price = price;
        this.description = description;
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

    /**
     * 保留十位小数四舍五入
     * @return
     */
    public double getOriginalprice() {
        return ((double)Math.round(originalprice * 10))/10;
    }

    public void setOriginalprice(double originalprice) {
        this.originalprice = ((double)Math.round(originalprice * 10))/10;
    }

    public int gettPrice() {
        return tPrice;
    }

    public void settPrice(int tPrice) {
        this.tPrice = tPrice;
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

    @Override
    public String toString() {
        return "DetailsItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", originalprice=" + originalprice +
                ", tPrice=" + tPrice +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
