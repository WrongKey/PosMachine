package com.thoughtworks.pos;

public class DiscountStrategy implements PromotionStrategy {
    private final Integer discountRatio;

    public DiscountStrategy(Integer discountRatio) {
        this.discountRatio = discountRatio;
    }

    @Override
    public CartItem apply(CartItem cartItem) {
        final double currentPrice = cartItem.getCurrentPrice();
        cartItem.setCurrentPrice(currentPrice * discountRatio);
        return cartItem;
    }

    @Override
    public Integer priority() {
        return 2;
    }
}
