package flow;

import java.time.LocalDate;

public abstract class Item {
    private String name;
    private double price;
    private int quantity;
    boolean isBudgetBrand;
    private String unit;

    public String getName() {
        return name;
    }

    public double getNormalprice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isBudgetBrand() {
        return isBudgetBrand;
    }

    public String getUnit() {
        return unit;
    }

    public Item(String name, double price, boolean isBudgetBrand, int quantity, String unit) {
        this.name = name;
        this.price = price;
        this.isBudgetBrand = isBudgetBrand;
        this.quantity = quantity;
        this.unit = unit;
    }
    @Override
    public String toString() {
        return name + " | Pris: " + price + " | Antal: " + quantity + " " + unit +
                (isBudgetBrand ? " | Budget" : "");
    }

}