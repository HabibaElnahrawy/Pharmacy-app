package com.example.pharmacyapp.model;

public class Product {
    String pName,pPrice,pImage;

    public Product(String pName, String pPrice, String pImage) {
        this.pName = pName;
        this.pPrice = pPrice;
        this.pImage = pImage;
    }

    public Product()
    {

    }
    public String getpName() {
        return pName;
    }

    public String getpPrice() {
        return pPrice;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }
}
