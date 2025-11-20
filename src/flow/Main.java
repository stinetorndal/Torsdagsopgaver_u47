package flow;

import service.CashRegister;
import service.ItemRepository;
import service.Shop;
import util.TextUI;

import java.util.List;

public class Main {
    static void main() {

        TextUI ui = new TextUI();
        ItemRepository repository = new ItemRepository();
        Shop shop = new Shop();
        CashRegister cashRegister = new CashRegister();

        ui.welcome();

        //------Varer indlæses fra csv-filer------
        List<Item> items = repository.loadItems("data/varer.csv", "data/tilbud.csv");

        //------Kalder metode fra textUI der prompter hvor mange varer, kunden vil have------
        int count = ui.askHowManyItems();

        //------Kurven genereres-------
        ShoppingCart cart = shop.generateRandomCart(items, count);

        //------Vis kurven med tilfældige varer------
        ui.showCart(cart);

        //------Betaling / kvittering------
        if (ui.askToPay()) {
            Receipt receipt = cashRegister.scanCart(cart);
            ui.showReceipt(receipt);
            } else {
            System.out.println("Handlen blev annulleret");
        }
    }
}
