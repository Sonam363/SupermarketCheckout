package main;

import java.util.HashMap;

public class PromotionList {
    public static HashMap<String, Promotion> itemPromotionMap = new HashMap<>();

    static{
        itemPromotionMap.put("B", new MultibuyPromotion("B", 2, 75, 125));
        itemPromotionMap.put("C", new GetOneFreePromotion("C", 3, 25));
//        itemPromotionMap.put("D", 150);
//        itemPromotionMap.put("E", 200);
    }
}

