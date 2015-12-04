package com.thoughtworks.pos.strategy;


import com.thoughtworks.pos.CartItem;

public class ReduceXUponYStrategy implements PromotionStrategy {
    private final Rule<Integer, Integer> reduceRule;

    public ReduceXUponYStrategy(Integer lowerBound, Integer discount) {
        this.reduceRule = new Rule<>(lowerBound, discount);
    }

    @Override
    public double apply(final CartItem cartItem, final double price) {
        double originSubtotal = cartItem.getQuantity() * price;
        int discountTimes = (int) originSubtotal / this.reduceRule.lowerBound;
        return (originSubtotal - discountTimes * this.reduceRule.discount) / cartItem.getQuantity();
    }

    public static final class Rule<L, R> {
        private final L lowerBound;
        private final R discount;

        public Rule(final L lowerBound, final R discount) {
            this.lowerBound = lowerBound;
            this.discount = discount;
        }
    }
}
