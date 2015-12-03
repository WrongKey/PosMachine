package com.thoughtworks.pos;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ItemParser itemParser = new ItemParser();
        List<Item> allItems = itemParser.parse(ShopData.ITEMS_DATA);
        PosMachine posMachine = new PosMachine(allItems, ShopData.ALL_PROMOTIONS);

        ShoppingCartParser shoppingCartParser = new ShoppingCartParser();
        List<CartItem> cartItems = shoppingCartParser.parse(ShopData.SHOPPING_CART_DATA);

        double total = posMachine.calculate(cartItems);
        System.out.println(total);
    }
}
