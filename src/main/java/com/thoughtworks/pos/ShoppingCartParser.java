package com.thoughtworks.pos;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class ShoppingCartParser extends Parser {
    private static final Pattern PATTERN = compile("^(\\w+)-(\\d+)$");

    @Override
    protected String getSeparator() {
        return "-";
    }

    @Override
    protected Pattern getPattern() {
        return PATTERN;
    }
}
