package com.thoughtworks.pos.strategy;

import com.thoughtworks.pos.CartItem;

public interface PromotionStrategy {
    double apply(CartItem cartItem, double price);
}
