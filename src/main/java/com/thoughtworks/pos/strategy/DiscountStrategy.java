package com.thoughtworks.pos.strategy;

import com.thoughtworks.pos.domain.CartItem;

public class DiscountStrategy implements PromotionStrategy {
    private final Integer discount;

    public DiscountStrategy(final Integer discount) {
        this.discount = discount;
    }

    @Override
    public double apply(final CartItem cartItem, final double price) {
        double discountRatio = discount / 100d;
        return price * cartItem.getQuantity() * discountRatio ;
    }
}
