package com.thoughtworks.pos.strategy;

import com.thoughtworks.pos.CartItem;

import java.util.List;

public class CompositeStrategy implements PromotionStrategy {
    private final List<PromotionStrategy> promotionStrategies;

    public CompositeStrategy(List<PromotionStrategy> promotionStrategies) {
        this.promotionStrategies = promotionStrategies;
    }

    @Override
    public double apply(final CartItem cartItem, final double price) {
        Integer quantity = cartItem.getQuantity();
        double subtotal = quantity * price;
        for (PromotionStrategy promotionStrategy : promotionStrategies) {
            subtotal = promotionStrategy.apply(cartItem, subtotal / quantity);
        }
        return subtotal;
    }
}
