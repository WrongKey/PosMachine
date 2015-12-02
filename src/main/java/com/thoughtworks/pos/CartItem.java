package com.thoughtworks.pos;

import java.util.List;

public final class CartItem {
    private final Item item;
    private Integer quantity;
    private double promotionPrice;

    public CartItem(Item item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public double getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(double promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public void applyPromotions(List<PromotionStrategy> promotionStrategies) {
        for (PromotionStrategy promotionStrategy : promotionStrategies) {
            promotionStrategy.apply(this);
        }
    }

    public void initPrice(double price) {
        this.item.setPrice(price);
        this.promotionPrice = price;
    }
}
