package com.thoughtworks.pos.strategy;

import com.thoughtworks.pos.CartItem;

public class SecondHalfStrategy implements PromotionStrategy {
    @Override
    public double apply(final CartItem cartItem, final double price) {
        final double currentPrice = price;
        final Integer quantity = cartItem.getQuantity();
        return currentPrice * quantity - quantity / 2 * currentPrice * 0.5;
    }
}
