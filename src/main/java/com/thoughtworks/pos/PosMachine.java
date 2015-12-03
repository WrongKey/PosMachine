package com.thoughtworks.pos;

import com.thoughtworks.pos.strategy.PromotionStrategy;

import java.util.*;

public final class PosMachine {
    private static final List<PromotionStrategy> EMPTY = new ArrayList<>();
    private final Map<String, List<PromotionStrategy>> allPromotions;
    private final List<Item> allItems;

    public PosMachine(List<Item> allItems, Map<String, List<PromotionStrategy>> allPromotions) {
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

    private List<PromotionStrategy> getAvailablePromotions(String barcode) {
        List<PromotionStrategy> availablePromotions = allPromotions.get(barcode);
        return availablePromotions == null ? EMPTY : availablePromotions;
    }
}
