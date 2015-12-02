package com.thoughtworks.pos;

public final class Item {
    private final String barcode;
    private double price;

    private Item(String barcode, double price) {
        this.barcode = barcode;
        this.price = price;
    }

    public Item setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getPrice() {
        return price;
    }

    public static Item createItemWithoutPrice(String barcode) {
        return new Item(barcode,0);
    }

    public static Item createItem(String barcode, double price) {
        return new Item(barcode, price);
    }
}
