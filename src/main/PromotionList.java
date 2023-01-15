package main;

import java.util.HashMap;
import java.util.Map;

public class PromotionList {
    public static HashMap<String, Promotion> itemPromotionMap = new HashMap<>();

    static{
        Map<String, Integer> itemToPriceMap = new HashMap<>();
        itemToPriceMap.put("D", 150);
        itemToPriceMap.put("E", 200);
        MealDealPromotion mealDealPromotion = new MealDealPromotion(itemToPriceMap, 300);

        itemPromotionMap.put("D", mealDealPromotion);
        itemPromotionMap.put("B", new MultibuyPromotion("B", 2, 75, 125));
        itemPromotionMap.put("C", new GetOneFreePromotion("C", 4, 25));
    }
}

