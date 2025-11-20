package service;

import flow.Item;
import flow.ShoppingCart;

import java.util.List;
import java.util.Random;

public class Shop {

    public ShoppingCart generateRandomCart(List<Item> items, int count) {
        ShoppingCart cart = new ShoppingCart();
        Random random = new Random();
        int maxTotal = count;
        int currentTotal = 0;

        while (currentTotal < maxTotal) {
            Item randomItem = items.get(random.nextInt(items.size()));
            int qty = random.nextInt(3) + 1;

            if ((currentTotal + qty > maxTotal)) {
                qty = maxTotal - currentTotal;
            }
            cart.addItem(randomItem, qty);
            currentTotal += qty;
        }
        return cart;
    }

}