package com.thoughtworks.pos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public abstract class Parser {
    public Map<String, Integer> parse(List<String> input) {
        HashMap<String, Integer> cartItems = new HashMap<>();
        for (String line : input) {
            validateInput(line);
            String[] splitInput = parseLine(line);
            cartItems.put(splitInput[0], parseInt(splitInput[1]));
        }
        return cartItems;
    }

    private void validateInput(String line) {
        if (!getPattern().matcher(line).matches()) {
            throw new IllegalArgumentException("invalid input format");
        }
    }

    private String[] parseLine(String line) {
        return line.split(getSeparator());
    }

    protected abstract String getSeparator();

    protected abstract Pattern getPattern() ;

}
