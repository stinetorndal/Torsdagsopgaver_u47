    package flow;

public class NormalItem extends Item {
    private double price;

    public NormalItem(String id, String name, double price) {
        super(id, name, null, 0, null);
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String toString (){
        return super.toString() + " - " + price + " kr";
    }
}
