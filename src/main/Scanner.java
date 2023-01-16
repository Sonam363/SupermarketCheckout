package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Scanner {

    public static PromotionList promotions;

    public Scanner(PromotionList promotions) {
        Scanner.promotions = promotions;
    }

    public double scan(List<String> itemsToScan) {
        // scan all items and create a running total
        // track the number of each item that a promotion applies to
        int runningTotal = 0;
        HashMap<String, Integer> itemPriceMap = PriceList.itemPriceMap;

        Map<String, Integer> itemCount = new HashMap<>();
        System.out.println("Items being scanned: ");

        for (String item : itemsToScan) {
            System.out.println(item);
            if (!itemPriceMap.containsKey(item)) {
                System.out.println("Invalid item scanned, please call the manager!");
                continue;
            }
            int count = itemCount.containsKey(item) ? itemCount.get(item) : 0;
            itemCount.put(item, count + 1);
            runningTotal += itemPriceMap.get(item);
        }

        return calculateTotal(itemCount, promotions, runningTotal);
    }

    private double calculateTotal(Map<String, Integer> itemCount, PromotionList promotions, int runningTotal) {
        HashMap<String, Promotion> itemPromotionMap = PromotionList.itemPromotionMap;
        for (String item : itemPromotionMap.keySet()) {
            if (itemCount.containsKey(item)) {
                Promotion promotion = itemPromotionMap.get(item);
                if (promotion instanceof MealDealPromotion) {
                    runningTotal -= promotion.calculatePromotion(getMealDealCount(itemCount, (MealDealPromotion) promotion));
                } else {
                    runningTotal -= promotion.calculatePromotion(itemCount.get(item));
                }
            }
        }
        double finalTotal = convertToPounds(runningTotal);
        System.out.println(String.format("Total cost of items: £%s", finalTotal));
        return finalTotal;
    }

    private double convertToPounds(int runningTotal) {
        double finalTotal = (double) runningTotal;
        return finalTotal/100;
    }

    private int getMealDealCount(Map<String, Integer> itemToQuantityMap, MealDealPromotion promotion) {
        // smallest value = number of complete meal deals
        int smallestValue = Integer.MAX_VALUE;
        // check if all items needed for meal deal are present
        Set<String> mealDealItems = promotion.itemToPriceMap.keySet();
        for (String item : mealDealItems) {
            if (!itemToQuantityMap.containsKey(item)) {
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
