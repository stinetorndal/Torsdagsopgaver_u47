package util;

import flow.Receipt;
import flow.ShoppingCart;

import java.util.Scanner;

public class TextUI {
    private Scanner scanner = new Scanner(System.in);

    public void welcome() {
        System.out.println("Velkommen i supermarkedet");
        System.out.println("**********************************");
    }

    public int askHowManyItems() {
        System.out.println("Hvor mange varer vil du købe i dag?  (max 15)");
        int count = scanner.nextInt();
        scanner.nextLine();
        if (count > 15) count = 15;
        if (count < 1) count = 1;
        return count;
    }

    public void showCart (ShoppingCart cart) {
        System.out.println("\nDu har følgende varer i din kurv: ");
        System.out.println("**********************************");

        cart.getItems().forEach(cartItem -> {
            var item = cartItem.getItem();
            System.out.println(
                    item.getName() +
                    " | Antal: " + cartItem.getQuantity() +
                    " | Pris: " + item.getNormalprice()
            );
        });
        System.out.println("**********************************");

    }
    public boolean askToPay(){
        System.out.println("Vil du betale nu? [j/n]: ");
        String answer = scanner.nextLine().trim().toLowerCase();
        return answer.equals("j");
    }
    public void showReceipt (Receipt receipt){
        System.out.println("\n------DIN KVITTERING------");
        System.out.println(receipt);
        System.out.println("**********************************");
    }
}
