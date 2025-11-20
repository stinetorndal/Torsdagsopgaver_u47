package flow;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, CartItem> items = new HashMap<>();

    public void addItem(Item item, int quantity){
        if (items.containsKey(item.getName())){
            //------Hvis vare allerede er i kurv, lægges antal til------
            CartItem alreadyInCart = items.get(item.getName());
            alreadyInCart.addQuantity(quantity);
        }  else {
            //------hvis vare ikke er i kurv, oprettes den------
            items.put(item.getName(), new CartItem(item, quantity));
        }
    }
    public Collection<CartItem> getItems(){
        return items.values();
    }
    //------check om kurven er tom------
    public boolean isEmpty(){
        return items.isEmpty();
    }
}
