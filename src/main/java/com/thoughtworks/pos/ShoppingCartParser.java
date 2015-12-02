package com.thoughtworks.pos;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class ShoppingCartParser extends Parser<CartItem> {
    private static final Pattern PATTERN = compile("^(\\w+)-(\\d+)$");

    @Override
    protected CartItem parseLine(String line) {
        String[] splitLine = line.split("-");
        Item item = Item.createItemWithoutPrice(splitLine[0]);
        int quantity = Integer.parseInt(splitLine[1]);
        return new CartItem(item, quantity);
    }

    @Override
    protected Pattern getPattern() {
        return PATTERN;
    }
}
