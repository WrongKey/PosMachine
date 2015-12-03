package com.thoughtworks.pos;

public final class Item {
    private final String barcode;
    private double price;

    public Item(String barcode, double price) {
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
}
