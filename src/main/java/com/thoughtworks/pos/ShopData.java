package com.thoughtworks.pos;

import com.thoughtworks.pos.strategy.DiscountStrategy;
import com.thoughtworks.pos.strategy.PromotionStrategy;
import com.thoughtworks.pos.strategy.ReduceXUponYStrategy;
import com.thoughtworks.pos.strategy.SecondHalfStrategy;

import java.util.*;

public final class ShopData {

    public static final List<String> ITEMS_DATA =
            Arrays.asList("ITEM000001:40", "ITEM000003:50", "ITEM000005:60");

    public static final List<String> SHOPPING_CART_DATA =
            Arrays.asList("ITEM000001-2", "ITEM000003-5", "ITEM000005-3");

    public static final Map<String, List<PromotionStrategy>> ALL_PROMOTIONS = new HashMap<>();

    static {
        List<PromotionStrategy> item1Promotion = new ArrayList<>();
        item1Promotion.add(new SecondHalfStrategy());
        item1Promotion.add(new DiscountStrategy(75));
        ALL_PROMOTIONS.put("ITEM000001", item1Promotion);

        List<PromotionStrategy> item3Promotion = new ArrayList<>();
        item3Promotion.add(new SecondHalfStrategy());
        item3Promotion.add(new ReduceXUponYStrategy(100, 10));
        ALL_PROMOTIONS.put("ITEM000003", item3Promotion);

        List<PromotionStrategy> item5Promotion = new ArrayList<>();
        item5Promotion.add(new DiscountStrategy(90));
        item5Promotion.add(new ReduceXUponYStrategy(300, 50));
        ALL_PROMOTIONS.put("ITEM000005", item5Promotion);
    }
}
