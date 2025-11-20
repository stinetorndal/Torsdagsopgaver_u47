package service;
import flow.CartItem;
import flow.DiscountedItems;
import flow.Item;
import flow.Receipt;
import flow.ShoppingCart;
import flow.ReceiptLine;



public class CashRegister {
    private static final double VAT_RATE = 0.25;

    public Receipt scanCart (ShoppingCart cart) {
        Receipt receipt = new Receipt();

        for (CartItem cartItem: cart.getItems()){
            Item item = cartItem.getItem();
            double normalPrice;
            double actualPrice;

            //------checker om vare er på tilbud------
            if (item instanceof DiscountedItems) {
                DiscountedItems d = (DiscountedItems) item;
                normalPrice = d.getNormalPrice();
                actualPrice = d.getPrice(); // kunden betaler tilbudsprisen
            } else {
                normalPrice = item.getPrice();
                actualPrice = item.getPrice();
            }

            // Lav en linje på bonen
            receipt.addLine(new ReceiptLine(item.getName(), normalPrice, actualPrice, cartItem.getQuantity()));
        }

        // Beregn moms
        receipt.calculateVAT(VAT_RATE);

        return receipt;
    }
}


