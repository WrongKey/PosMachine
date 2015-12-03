package com.thoughtworks.pos.strategy;

import com.thoughtworks.pos.CartItem;

public class DiscountStrategy implements PromotionStrategy {
    private final Integer discount;

    public DiscountStrategy(Integer discount) {
        this.discount = discount;
    }

    @Override
    public CartItem apply(CartItem cartItem) {
        final double currentPrice = cartItem.getCurrentPrice();
        double discountRatio = discount / 100d;
        cartItem.setCurrentPrice(currentPrice * discountRatio);
        return cartItem;
    }

    @Override
    public Integer priority() {
        return 2;
    }
}
