package com.thoughtworks.pos;

import java.util.List;

public final class PosMachine {
    private final List<Item> allItems;

    public PosMachine(List<Item> allItems) {
        this.allItems = allItems;
    }

    public double calculate(List<CartItem> cartItems) {
        double total = 0;
        for (CartItem cartItem : cartItems) {
            String barcode = cartItem.getItem().getBarcode();
            cartItem.initPrice(queryItemPrice(barcode));
            cartItem.applyPromotions(getAvailablePromotions(barcode));
            total += cartItem.getQuantity() * cartItem.getPromotionPrice();
        }
        return total;
    }

    private double queryItemPrice(String barcode) {
        for (Item item : allItems) {
            if (item.getBarcode().equals(barcode)){
                return item.getPrice();
            }
        }

        throw new IllegalArgumentException("unknown item");
    }

    private List<PromotionStrategy> getAvailablePromotions(String barcode) {
        return null;
    }
}
