package com.thoughtworks.pos;

public class ReduceXUponYStrategy implements PromotionStrategy {
    private final Rule<Integer, Integer> reduceRule;

    public ReduceXUponYStrategy(Rule<Integer, Integer> reduceRule) {
        this.reduceRule = reduceRule;
    }

    @Override
    public CartItem apply(CartItem cartItem) {
        double originSubtotal = cartItem.subtotal();
        double discountTimes = ((int)originSubtotal) / this.reduceRule.lowerBound;
        double currentPromotionPrice = (originSubtotal - discountTimes * this.reduceRule.discount) / cartItem.getQuantity();
        cartItem.setCurrentPrice(currentPromotionPrice);
        return cartItem;
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
