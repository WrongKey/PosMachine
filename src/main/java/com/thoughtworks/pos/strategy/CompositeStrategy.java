package com.thoughtworks.pos.strategy;

import com.thoughtworks.pos.CartItem;

import java.util.List;

public class CompositeStrategy implements PromotionStrategy {
    private final List<PromotionStrategy> promotionStrategies;

    public CompositeStrategy(List<PromotionStrategy> promotionStrategies) {
        this.promotionStrategies = promotionStrategies;
    }

    @Override
    public double apply(CartItem cartItem, double price) {
        double currentPrice = price;
        for (PromotionStrategy promotionStrategy : promotionStrategies) {
            currentPrice = promotionStrategy.apply(cartItem, currentPrice);
        }
        return currentPrice;
    }
}
