package com.thoughtworks.pos.strategy;

import com.thoughtworks.pos.domain.CartItem;

public class SecondHalfStrategy implements PromotionStrategy {
    @Override
    public double apply(final CartItem cartItem, final double price) {
        final Integer quantity = cartItem.getQuantity();
        return price * quantity - (quantity / 2) * (price * 0.5);
    }
}
