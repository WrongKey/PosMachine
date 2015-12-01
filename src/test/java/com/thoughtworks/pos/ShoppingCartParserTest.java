package com.thoughtworks.pos;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ShoppingCartParserTest {
    private ShoppingCartParser parser;

    @Before
    public void setUp() {
        parser = new ShoppingCartParser();
    }

    @Test
    public void should_get_empty_when_given_none() {
        Map<String, Integer> cartItems = parser.parse(Arrays.<String>asList());
        Map<String, Integer> expectedCartItems = new HashMap<String, Integer>();
        assertThat(cartItems, is(expectedCartItems));
    }

    @Test
    public void should_get_1_cart_item() {
        Map<String, Integer> cartItems = parser.parse(Arrays.asList("I1-2"));
        Map<String, Integer> expectedCartItems = new HashMap<String, Integer>();
        expectedCartItems.put("I1", 2);
        assertThat(cartItems, is(expectedCartItems));
    }

    @Test
    public void should_get_2_cart_item() {
        Map<String, Integer> cartItems = parser.parse(Arrays.asList("I1-2", "I2-3"));
        Map<String, Integer> expectedCartItems = new HashMap<String, Integer>();
        expectedCartItems.put("I1", 2);
        expectedCartItems.put("I2", 3);
        assertThat(cartItems, is(expectedCartItems));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_complain_with_invalid_input_format() {
        parser.parse(Arrays.<String>asList("wahaha"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_complain_with_invalid_amount() {
        parser.parse(Arrays.<String>asList("T1-2b"));
    }
}
