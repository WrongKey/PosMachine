package com.thoughtworks.pos;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

    public void applyPromotions(Set<PromotionStrategy> promotionStrategies) {
        Comparator<PromotionStrategy> promotionStrategyComparator = new Comparator<PromotionStrategy>() {
            @Override
            public int compare(PromotionStrategy ps1, PromotionStrategy ps2) {
                return ps1.priority() - ps2.priority();
            }
        };

        TreeSet<PromotionStrategy> sortedPromotionStrategies = new TreeSet<>(promotionStrategyComparator);
        sortedPromotionStrategies.addAll(promotionStrategies);
        for (PromotionStrategy promotionStrategy : sortedPromotionStrategies) {
            promotionStrategy.apply(this);
        }
    }
}
