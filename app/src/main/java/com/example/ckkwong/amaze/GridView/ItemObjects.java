package com.example.ckkwong.amaze.GridView;

public class ItemObjects {
    private String name;
    private int photo;
    private String itemId;
    private Boolean isFavorite;
    private String price;

    public ItemObjects(String name, int photo) {
        this.name = name;
        this.photo = photo;
        this.isFavorite = false;
        this.price = "100.0";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setItemId(String id) {this.itemId = id; }

    public String getItemId() {return itemId; }

    public void setIsFavorite(Boolean is) {this.isFavorite = is; }

    public Boolean getIsFavorite(){return this.isFavorite; }

    public String getPrice(){return this.price; }

    public void setPrice(String price){this.price = price; }
}
