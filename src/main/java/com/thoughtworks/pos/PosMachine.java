package com.thoughtworks.pos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class PosMachine {
    private static final List<PromotionStrategy> EMPTY_LIST = new ArrayList<>();
    private final List<Item> allItems;
    private final Map<String, List<PromotionStrategy>> allPromotions;

    public PosMachine(List<Item> allItems, Map<String, List<PromotionStrategy>> allPromotions) {
        this.allItems = allItems;
        this.allPromotions = allPromotions;
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
        List<PromotionStrategy> availablePromotions = allPromotions.get(barcode);
        return availablePromotions == null ? EMPTY_LIST : availablePromotions;
    }
}
