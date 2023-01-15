import main.GetOneFreePromotion;
import main.MealDealPromotion;
import main.MultibuyPromotion;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PromotionsTest {

    @Test
    public void applyMultibuyPromotionEvenTest(){
        int pricePerUnit = 75;
        int promotionalPrice = 125;
        int itemsScanned = 6;

        MultibuyPromotion mp = new MultibuyPromotion("B", 2, pricePerUnit, promotionalPrice);
        int amountToDeduct = mp.calculatePromotion(itemsScanned);
        int totalPrice = itemsScanned*pricePerUnit;

        assertEquals(amountToDeduct, 75);
        assertEquals(totalPrice-amountToDeduct, 375);
    }

    @Test
    public void applyMultibuyPromotionOddTest(){
        int pricePerUnit = 100;
        int promotionalPrice = 100;
        int itemsScanned = 9;

        MultibuyPromotion mp = new MultibuyPromotion("B", 2, pricePerUnit, promotionalPrice);
        int amountToDeduct = mp.calculatePromotion(itemsScanned);
        int totalPrice = itemsScanned*pricePerUnit;

        assertEquals(amountToDeduct, 400);
        assertEquals(totalPrice-amountToDeduct, 500);
    }

    @Test
    public void applyGetOneFreePromotionTest(){
        int pricePerUnit = 100;
        int itemsScanned = 10;
        int quantityNeeded = 4;

        GetOneFreePromotion p = new GetOneFreePromotion("B", quantityNeeded, pricePerUnit);
        int amountToDeduct = p.calculatePromotion(itemsScanned);
        int totalPrice = itemsScanned*pricePerUnit;

        assertEquals(amountToDeduct, 200);
        assertEquals(totalPrice-amountToDeduct, 800);
    }

    @Test
    public void applyMealDealPromotionTest(){
        Map<String, Integer> itemToPriceMap = new HashMap<>();
        itemToPriceMap.put("D", 150);
        itemToPriceMap.put("E", 200);
        MealDealPromotion p = new MealDealPromotion(itemToPriceMap, 300);

        Map<String, Integer> itemToQuantityMap = new HashMap<>();
        itemToQuantityMap.put("D", 3);
        itemToQuantityMap.put("E", 2);

        int amountToDeduct = p.calculatePromotion(itemToQuantityMap);
        int totalPrice = 0;
        for (HashMap.Entry<String, Integer> entry : itemToQuantityMap.entrySet()) {
            String itemSKU = entry.getKey();
            int quantity = entry.getValue();
            int priceForItem = itemToPriceMap.get(itemSKU);
            totalPrice += priceForItem*quantity;
        }

        assertEquals(amountToDeduct, 100);
        assertEquals(totalPrice-amountToDeduct, 750);
    }
}