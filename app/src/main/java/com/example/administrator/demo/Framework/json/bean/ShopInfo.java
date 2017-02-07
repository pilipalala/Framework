package com.example.administrator.demo.Framework.json.bean;

/**
 * Created by Administrator on 2016/12/15.
 */
//实体类
public class ShopInfo {
    private int id;
    private String name;
    private Double price;
    private String imagePath;


    public ShopInfo() {
    }


    @Override
    public String toString() {
        return "ShopInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

    public ShopInfo(int id, String name, Double price, String imagePath) {
        this.id = id;
        this.imagePath = imagePath;
        this.name = name;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
