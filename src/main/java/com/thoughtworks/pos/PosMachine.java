package com.thoughtworks.pos;

import java.util.*;

public final class PosMachine {
    private static final Set<PromotionStrategy> EMPTY = new TreeSet<>();
    private final Map<String, Set<PromotionStrategy>> allPromotions;
    private final List<Item> allItems;

    public PosMachine(List<Item> allItems, Map<String, Set<PromotionStrategy>> allPromotions) {
        this.allItems = allItems;
        this.allPromotions = allPromotions;
    }

    public double calculate(List<CartItem> cartItems) {
        double total = 0;
        for (CartItem cartItem : cartItems) {
            cartItem.setCurrentPrice(queryItemPrice(cartItem.getBarcode()));
            cartItem.applyPromotions(getAvailablePromotions(cartItem.getBarcode()));
            total += cartItem.subtotal();
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

    private Set<PromotionStrategy> getAvailablePromotions(String barcode) {
        Set<PromotionStrategy> availablePromotions = allPromotions.get(barcode);
        return availablePromotions == null ? EMPTY : availablePromotions;
    }
}
