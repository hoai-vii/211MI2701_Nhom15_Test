package com.example.model;

public class Product {
    private int MaSP;
    private String productName;
    private String HangSX;
    private Float Price;
    private byte[] imageProduct;

    public void setMaSP(int maSP) {
        MaSP = maSP;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setHangSX(String hangSX) {
        HangSX = hangSX;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public void setImageProduct(byte[] imageProduct) {
        this.imageProduct = imageProduct;
    }

    public int getMaSP() {
        return MaSP;
    }

    public String getProductName() {
        return productName;
    }

    public String getHangSX() {
        return HangSX;
    }

    public Float getPrice() {
        return Price;
    }

    public byte[] getImageProduct() {
        return imageProduct;
    }

    public Product(int maSP, String productName, String hangSX, Float price, byte[] imageProduct) {
        MaSP = maSP;
        this.productName = productName;
        HangSX = hangSX;
        Price = price;
        this.imageProduct = imageProduct;
    }
}
