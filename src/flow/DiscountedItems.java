package flow;

public class DiscountedItems extends Item {
    private double normalPrice;

    public DiscountedItems(String name, double price, double normalPrice, boolean isBudgetBrand, int quantity, String unit) {
        super(name, price, isBudgetBrand, quantity, unit);
        this.normalPrice = normalPrice;
    }

    public double getNormalPrice() {
        return normalPrice;
    }

    @Override
    public String toString() {
        return super.toString() + " | Normalpris: " + normalPrice;
    }
}
