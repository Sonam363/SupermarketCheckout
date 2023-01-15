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
        int deductionAmount = pricePerUnit;

        return (itemsScanned/quantityNeeded) * deductionAmount;
    }

    @Override
    public void describe() {
        System.out.println(String.format("Buy %s get 1 free", quantityNeeded-1));
    }
}
