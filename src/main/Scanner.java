package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Scanner {

    public static PromotionList promotions;

    public Scanner(PromotionList promotions) {
        this.promotions = promotions;
    }

    public int scan(List<String> itemsToScan) {
        // scan all items and create a running total
        // track the number of each item that a promotion applies to
        int runningTotal = 0;
        HashMap<String, Integer> itemPriceMap = PriceList.itemPriceMap;

        Map<String, Integer> itemCount = new HashMap<>();
        System.out.println("Items being scanned: ");

        for(String item : itemsToScan) {
            System.out.println(item);
            int count = itemCount.containsKey(item) ? itemCount.get(item) : 0;
            itemCount.put(item, count + 1);
            runningTotal += itemPriceMap.get(item);
        }

        return calculateTotal(itemCount, promotions, runningTotal);
    }

    private int calculateTotal(Map<String, Integer> itemCount, PromotionList promotions, int runningTotal) {
        HashMap<String, Promotion> itemPromotionMap = promotions.itemPromotionMap;
        for(String item : itemPromotionMap.keySet()) {
            if(itemCount.containsKey(item)) {
                Promotion promotion = itemPromotionMap.get(item);
                if(promotion instanceof MealDealPromotion) {
                    runningTotal -= promotion.calculatePromotion(getMealDealCount(itemCount, (MealDealPromotion) promotion));
                } else {
                    runningTotal -= promotion.calculatePromotion(itemCount.get(item));
                }
            }
        }
        return runningTotal;
    }

    private int getMealDealCount(Map<String, Integer> itemToQuantityMap, MealDealPromotion promotion) {
        // smallest value = number of complete meal deals
        int smallestValue = Integer.MAX_VALUE;
        // check if all items needed for meal deal are present
        Set<String> mealDealItems = promotion.itemToPriceMap.keySet();
        for(String item : mealDealItems) {
            if(!itemToQuantityMap.containsValue(item)) {
                return 0; // doesn't meet promotion criteria
            } else {
                if (itemToQuantityMap.get(item) < smallestValue) {
                    smallestValue = itemToQuantityMap.get(item);
                }
            }
        }
        return smallestValue;
    }
}
