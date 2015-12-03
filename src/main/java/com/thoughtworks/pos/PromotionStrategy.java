package com.thoughtworks.pos;

public interface PromotionStrategy extends Priority{
    CartItem apply(CartItem cartItem);
}
