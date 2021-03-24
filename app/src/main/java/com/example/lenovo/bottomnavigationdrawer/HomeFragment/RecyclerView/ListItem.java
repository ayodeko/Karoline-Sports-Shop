package com.example.lenovo.bottomnavigationdrawer.HomeFragment.RecyclerView;

import android.graphics.Bitmap;

import com.example.lenovo.bottomnavigationdrawer.R;

public class ListItem {

    String Name;
    String Price;
    int ImageResource;
    Bitmap ImageBitmap;


    public ListItem(String name, String price, int imageResource) {
        Name = name;
        Price = price;
        ImageResource = imageResource;
    }

    public ListItem(String name, String price, Bitmap imageBitmap) {
        Name = name;
        Price = price;
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

    public Bitmap getImageBitmap() {
        return ImageBitmap;
    }

    public void setImageBitmap(Bitmap imageBitmap) {
        ImageBitmap = imageBitmap;
    }
}