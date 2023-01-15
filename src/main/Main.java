package main;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Initialising current promotions: ");
        PromotionList.itemPromotionMap.entrySet().forEach(promotion -> promotion.getValue().describe());

        List<String> itemsToScan = Arrays.asList("E", "A", "A", "B", "C", "A", "B", "D");
        Scanner scanner = new Scanner(new PromotionList());
        scanner.scan(itemsToScan);
    }

    // edge cases - items thatt dontt have a sku, empty list of items,
}
