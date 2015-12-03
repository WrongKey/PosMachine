package com.thoughtworks.pos.strategy;

import com.thoughtworks.pos.CartItem;

public class SecondHalfStrategy implements PromotionStrategy {
    @Override
    public CartItem apply(CartItem cartItem) {
        final double currentPrice = cartItem.getCurrentPrice();
        final Integer quantity = cartItem.getQuantity();
        final double promotionSubtotal = currentPrice * quantity - quantity / 2 * currentPrice * 0.5;
        final double promotionPrice = promotionSubtotal / quantity;
        cartItem.setCurrentPrice(promotionPrice);
        return cartItem;
    }

    @Override
    public Integer priority() {
        return 1;
    }
}
