package com.thoughtworks.pos;

public interface PromotionStrategy {
    CartItem apply(CartItem cartItem);
}
