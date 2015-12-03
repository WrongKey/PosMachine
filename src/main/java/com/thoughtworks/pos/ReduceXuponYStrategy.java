package com.thoughtworks.pos;

import java.util.Map;

public class ReduceXUponYStrategy implements PromotionStrategy {
    private final Map<String, Rule<Integer, Integer>> reduceRuleMap;

    public ReduceXUponYStrategy(Map<String, Rule<Integer, Integer>> reduceRuleMap) {
        this.reduceRuleMap = reduceRuleMap;
    }

    @Override
    public CartItem apply(CartItem cartItem) {
        double originSubtotal = cartItem.subtotal();
        Rule<Integer, Integer> rule = reduceRuleMap.get(cartItem.getBarcode());
        double discountTimes = ((int)originSubtotal) / rule.lowerBound;
        double currentPromotionPrice = (originSubtotal - discountTimes * rule.discount) / cartItem.getQuantity();
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
