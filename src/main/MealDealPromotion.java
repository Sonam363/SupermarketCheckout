package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MealDealPromotion implements Promotion {

    public Map<String, Integer> itemToPriceMap;
    public int totalPricePerDeal;

    public MealDealPromotion(Map<String, Integer> itemToPriceMap, int totalPricePerDeal) {
        this.itemToPriceMap = itemToPriceMap;
        this.totalPricePerDeal = totalPricePerDeal;
    }

    // return amount to be deducted
    public int calculatePromotion(int numberOfMealDeals) {
        // original price = sum of individual products in the deal before discount
        int originalPrice = 0;
        for (HashMap.Entry<String, Integer> entry : itemToPriceMap.entrySet()) {
            originalPrice += entry.getValue();
        }

        int deductionAmount = originalPrice - totalPricePerDeal;

        return numberOfMealDeals * deductionAmount;
    }

    @Override
    public void describe() {
        Set<String> items = itemToPriceMap.keySet();
        StringBuilder builder = new StringBuilder();
        for (String item : items) builder.append(item).append(",");
        System.out.println(String.format("Meal deal: items %s for just %s", builder.toString(), totalPricePerDeal));
    }
}
