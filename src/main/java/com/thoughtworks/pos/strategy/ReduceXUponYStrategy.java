package com.thoughtworks.pos.strategy;


import com.thoughtworks.pos.domain.CartItem;

public class ReduceXUponYStrategy implements PromotionStrategy {
    private final Integer lowerBound;
    private final Integer discount;

    public ReduceXUponYStrategy(Integer lowerBound, Integer discount) {
        this.lowerBound = lowerBound;
        this.discount = discount;
    }

    @Override
    public double apply(final CartItem cartItem, final double price) {
        double originSubtotal = cartItem.getQuantity() * price;
        int discountTimes = (int) originSubtotal / lowerBound;
        double subtotal = (originSubtotal - discountTimes * discount);
        return subtotal;
    }
}
