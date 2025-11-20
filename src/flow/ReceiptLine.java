package flow;

public class ReceiptLine {
    private String itemName;
    private double normalPrice;
    private double actualPrice;
    private int quantity;
    private double total;
    private double discount;

    public ReceiptLine (String itemName, double normalPrice, double actualPrice, int quantity){
        this.itemName = itemName;
        this.normalPrice = normalPrice;
        this.actualPrice = actualPrice;
        this.quantity = quantity;
        this.total = actualPrice * quantity;
        this.discount= normalPrice * quantity - total;
    }
    public double getTotal() {
        return total;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscount() {
        return discount;
    }
    @Override
    public String toString (){
        String s = itemName +  ": " + quantity + " * " + normalPrice + " = " + total;
        if (discount > 0){
            s += " (Rabat: -" + discount + ")";
        }
        return  s;
    }
}
