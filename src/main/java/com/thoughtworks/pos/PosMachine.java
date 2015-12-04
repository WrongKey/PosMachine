package com.thoughtworks.pos;

import com.thoughtworks.pos.strategy.PromotionStrategy;

import java.util.*;

public final class PosMachine {
    private final Map<String, PromotionStrategy> allPromotions;
    private final List<Item> allItems;

    public PosMachine(final List<Item> allItems, final Map<String, PromotionStrategy> allPromotions) {
        this.allItems = allItems;
        this.allPromotions = allPromotions;
    }

    public double calculate(final List<CartItem> cartItems) {
        double total = 0;
        for (CartItem cartItem : cartItems) {
            total +=  calculateSubtotal(cartItem);
        }
        return total;
    }

    private double calculateSubtotal(final CartItem cartItem) {
        String barcode = cartItem.getBarcode();
        PromotionStrategy promotionStrategy = getAvailablePromotions(barcode);
        double originPrice = queryItemPrice(barcode);
        double currentPrice = promotionStrategy.apply(cartItem, originPrice);
        return cartItem.getQuantity() * currentPrice;
    }

    private double queryItemPrice(final String barcode) {
        for (Item item : allItems) {
            if (item.getBarcode().equals(barcode)){
                return item.getPrice();
            }
        }

        throw new IllegalArgumentException("unknown item");
    }

    private PromotionStrategy getAvailablePromotions(final String barcode) {
        return allPromotions.get(barcode);
    }
}
