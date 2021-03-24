package com.example.lenovo.bottomnavigationdrawer.CartFragment.RecyclerView;

import android.graphics.Bitmap;

public class ListItem {

    String Name;
    String Price;
    int ImageResource;
    String Material;
    String Color;
    int Quantity;
    String Category;

    Bitmap ImageBitmap;


    public ListItem(String name, String price, int imageResource) {
        Name = name;
        Price = price;
        ImageResource = imageResource;
        Quantity = 1;
    }

    public ListItem(String name, String price, String category, Bitmap imageBitmap) {
        Name = name;
        Price = price;
        Category = category;
        ImageBitmap = imageBitmap;
    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return Price;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public int getImageResource() {
        return ImageResource;
    }

    public void setImageId(int imageResource) {
        ImageResource = imageResource;
    }

    public String getMaterial() {
        return Material;
    }

    public String getColor() {
        return Color;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setImageResource(int imageResource) {
        ImageResource = imageResource;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Bitmap getImageBitmap() {
        return ImageBitmap;
    }

    public void setImageBitmap(Bitmap imageBitmap) {
        ImageBitmap = imageBitmap;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
