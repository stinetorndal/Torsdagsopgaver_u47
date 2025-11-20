package service;

import flow.Item;
import flow.NormalItem;
import flow.DiscountedItems;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemRepository {

    public List<Item> loadItems(String normalPath, String discountedPath) {
        List<Item> items = new ArrayList<>();
        items.addAll(loadCsv(normalPath, false));
        items.addAll(loadCsv(discountedPath, true));
        return items;
    }

    private List<Item> loadCsv(String path, boolean discounted) {
        List<Item> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(path))) {
            //------springe header over i csv------
            if (sc.hasNextLine()) sc.nextLine();

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] t = line.split(";");

                //------check om der er kolonner nok------
                if (t.length < 7) continue;

                try {
                    //------her er kun de kolonner i csv jeg har valgt at bruge------
                    String name = t[1].trim();
                    double price = Double.parseDouble(t[3].trim());
                    boolean isBudget = Boolean.parseBoolean(t[4].trim());
                    int quantity = Integer.parseInt(t[5].trim());
                    String unit = t[6].trim();

                    if (discounted) {
                        list.add(new DiscountedItems(name, price, price, isBudget, quantity, unit));
                    } else {
                        list.add(new NormalItem(name, price, isBudget, quantity, unit));
                    }
                    //-----springer over hvis der er fejl i linjen------
                } catch (Exception ignored) {

                }
            }
        } catch (Exception e) {
            System.out.println("Fejl ved indlæsning af " + path + ": " + e.getMessage());
        }
        return list;
    }
}

