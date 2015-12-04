package com.thoughtworks.pos.strategy;

import com.thoughtworks.pos.CartItem;

public class DiscountStrategy implements PromotionStrategy {
    private final Integer discount;

    public DiscountStrategy(Integer discount) {
        this.discount = discount;
    }

    @Override
    public double apply(CartItem cartItem, double price) {
        double discountRatio = discount / 100d;
        return price * discountRatio;
    }
}
