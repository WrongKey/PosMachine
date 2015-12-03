package com.thoughtworks.pos.strategy;


import com.thoughtworks.pos.CartItem;

public class ReduceXUponYStrategy implements PromotionStrategy{
    private final Rule<Integer, Integer> reduceRule;

    public ReduceXUponYStrategy(Integer lowerBound, Integer discount) {
        this.reduceRule = new Rule<>(lowerBound,discount);
    }

    @Override
    public CartItem apply(CartItem cartItem) {
        double originSubtotal = cartItem.subtotal();
        double discountTimes = ((int)originSubtotal) / this.reduceRule.lowerBound;
        double currentPromotionPrice = (originSubtotal - discountTimes * this.reduceRule.discount) / cartItem.getQuantity();
        cartItem.setCurrentPrice(currentPromotionPrice);
        return cartItem;
    }

    @Override
    public Integer priority() {
        return 0;
    }

    public static final class Rule<L,R> {
        private final L lowerBound;
        private final R discount;

        public Rule(L lowerBound, R discount) {
            this.lowerBound = lowerBound;
            this.discount = discount;
        }
    }
}
