package com.thoughtworks.pos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Data {

    public static final List<String> ITEMS_DATA =
            Arrays.asList("ITEM000001:40", "ITEM000003:50", "ITEM000005:60");

    public static final List<String> SHOPPING_CART_DATA =
            Arrays.asList("ITEM000001-2", "ITEM000003-5", "ITEM000005-3");

    public static final List<String> SECOND_HALF_ITEMS =
            Arrays.asList("ITEM000001", "ITEM000003");

    public static final Map<String, Integer> ITEM_DISCOUNT_MAP = new HashMap<>();

    public static final Map<String, ReduceXuponYStrategy.Rule<Integer, Integer>> REDUCE_X_UPON_Y_MAP = new HashMap<>();



    static {
        ITEM_DISCOUNT_MAP.put("ITEM000001", 75);
        ITEM_DISCOUNT_MAP.put("ITEM000005", 90);

        REDUCE_X_UPON_Y_MAP.put("ITEM000003", new ReduceXuponYStrategy.Rule<>(100,10));
        REDUCE_X_UPON_Y_MAP.put("ITEM000003", new ReduceXuponYStrategy.Rule<>(300,50));
    }
}
