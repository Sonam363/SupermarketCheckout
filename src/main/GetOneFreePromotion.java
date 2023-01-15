package main;

public class GetOneFreePromotion implements Promotion {

    public String itemSKU;
    public int quantityNeeded;
    public int pricePerUnit;

    public GetOneFreePromotion(String itemSKU, int quantityNeeded, int pricePerUnit) {
        this.itemSKU = itemSKU;
        this.quantityNeeded = quantityNeeded;
        this.pricePerUnit = pricePerUnit;
    }

    // return amount to be deducted
    public int calculatePromotion(int itemsScanned) {
        int originalPrice = quantityNeeded * pricePerUnit;
        int deductionAmount = pricePerUnit;

        return (itemsScanned/quantityNeeded) * deductionAmount;
    }
}
