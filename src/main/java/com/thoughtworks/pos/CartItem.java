package com.thoughtworks.pos;

import java.util.List;

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

    public void applyPromotions(List<PromotionStrategy> promotionStrategies) {
        for (PromotionStrategy promotionStrategy : promotionStrategies) {
            promotionStrategy.apply(this);
        }
    }

    double subtotal() {
        return getQuantity() * getCurrentPrice();
    }
}
