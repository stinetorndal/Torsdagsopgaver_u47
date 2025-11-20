package flow;

public class CartItem {
    private Item item;
    private int quantity;

    public CartItem(Item item, int quantity) {
        this.item =  item;
        this.quantity = quantity;
    }
    public double getTotal (){
        return item.getPrice() * quantity;
    }
    public void addQuantity (int q) {
        quantity += q;
    }
    public Item getItem(){
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
