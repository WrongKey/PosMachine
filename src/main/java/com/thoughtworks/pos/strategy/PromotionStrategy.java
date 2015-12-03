package com.thoughtworks.pos.strategy;

import com.thoughtworks.pos.CartItem;

public interface PromotionStrategy extends Priority{
    CartItem apply(CartItem cartItem);
}
