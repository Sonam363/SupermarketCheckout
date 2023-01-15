package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scanner {

    public static PromotionList promotions;

    public Scanner(PromotionList promotions) {
        this.promotions = promotions;
    }

    public int scan(List<String> itemsToScan) {
        // scan all items and track the number of each item
        Map<String, Integer> itemCount = new HashMap<>();
        System.out.println("Items being scanned: ");

        for(String item : itemsToScan) {
            System.out.println(item);
            int count = itemCount.containsKey(item) ? itemCount.get(item) : 0;
            itemCount.put(item, count + 1);
        }

        return calculateTotal(itemCount, promotions);
    }

    private int calculateTotal(Map<String, Integer> itemCount, PromotionList promotions) {

    }
}
