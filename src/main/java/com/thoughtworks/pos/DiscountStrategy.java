package com.thoughtworks.pos;

import java.util.Map;

public class DiscountStrategy implements PromotionStrategy {
    private final Map<String, Integer> itemDiscountMap;

    public DiscountStrategy(Map<String, Integer> itemDiscountMap) {
        this.itemDiscountMap = itemDiscountMap;
    }

    @Override
    public CartItem apply(CartItem cartItem) {
        final double currentPrice = cartItem.getCurrentPrice();
        final String barcode = cartItem.getBarcode();
        cartItem.setCurrentPrice(currentPrice * itemDiscountMap.get(barcode));
        return cartItem;
    }
}
