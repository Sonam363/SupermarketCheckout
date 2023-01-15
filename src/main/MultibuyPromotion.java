package main;

public class MultibuyPromotion implements Promotion {

    public String itemSKU;
    public int quantityNeeded;
    public int pricePerUnit;
    public int promotionalPrice;

    public MultibuyPromotion(String itemSKU, int quantityNeeded, int pricePerUnit, int promotionalPrice) {
        this.itemSKU = itemSKU;
        this.quantityNeeded = quantityNeeded;
        this.pricePerUnit = pricePerUnit;
        this.promotionalPrice = promotionalPrice;
    }

    // return amount to be deducted
    public int calculatePromotion(int itemsScanned) {
        int originalPrice = quantityNeeded * pricePerUnit;
        int deductionAmount = originalPrice - promotionalPrice;

        return (itemsScanned/quantityNeeded) * deductionAmount;
    }
}
