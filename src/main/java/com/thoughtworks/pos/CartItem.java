package com.thoughtworks.pos;

import com.thoughtworks.pos.strategy.PromotionStrategy;

import java.util.*;

public final class CartItem {
    private final String barcode;
    private Integer quantity;
    private double currentPrice;

    public CartItem(String barcode, Integer quantity) {
        this.barcode = barcode;
        this.quantity = quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public final double subtotal() {
        return getQuantity() * getCurrentPrice();
    }

    public void applyPromotions(List<PromotionStrategy> promotionStrategies) {
        Comparator<PromotionStrategy> promotionStrategyComparator = new Comparator<PromotionStrategy>() {
            @Override
            public int compare(PromotionStrategy ps1, PromotionStrategy ps2) {
                return ps2.priority() - ps1.priority();
            }
        };

        Collections.sort(promotionStrategies,promotionStrategyComparator);
        for (PromotionStrategy promotionStrategy : promotionStrategies) {
            promotionStrategy.apply(this);
        }
    }
}
