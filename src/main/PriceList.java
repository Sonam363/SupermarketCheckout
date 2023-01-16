package main;

import java.util.HashMap;

public class PriceList {
    public static HashMap<String, Integer> itemPriceMap = new HashMap<>();

    static {
        itemPriceMap.put("A", 50);
        itemPriceMap.put("B", 75);
        itemPriceMap.put("C", 25);
        itemPriceMap.put("D", 150);
        itemPriceMap.put("E", 200);
    }
}

