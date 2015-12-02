package com.thoughtworks.pos;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class Parser<T> {
    public List<T> parse(List<String> input) {
        List<T> list = new ArrayList<>();
        for (String line : input) {
            validateInput(line);
            list.add(parseLine(line));
        }
        return list;
    }

    private void validateInput(String line) {
        if (!getPattern().matcher(line).matches()) {
            throw new IllegalArgumentException("invalid input format");
        }
    }

    protected abstract T parseLine(String line);

    protected abstract Pattern getPattern() ;

}
