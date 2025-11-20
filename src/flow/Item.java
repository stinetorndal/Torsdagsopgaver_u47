package flow;

import java.time.LocalDate;

public abstract class Item {
    private String id;
    private String name;
    private LocalDate priceDate;
    private int quantity;
    private String unit;

    public Item(String id, String name, LocalDate priceDate, int quantity, String unit){
        this.id = id;
        this.name = name;
        this.priceDate = priceDate;
        this.quantity = quantity;
        this.unit = unit;
    }

    public abstract double getPrice();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getPriceDate() {
        return priceDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString(){
        return name + " (" + id + ")";
    }

}
