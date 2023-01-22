package structural.facade;

import java.util.Hashtable;

import structural.flyweight.Cargo;
import structural.flyweight.Item;

enum CargoSettings {
    PIZZA_HUT,
    HOT_STUFF,
    KFC
}

public class CargoFactory {

    private static Hashtable<String, Item> items = new Hashtable<>();
    private static boolean hasSetupItems = false;

    public static Cargo instantiate(CargoSettings settings) {
        if (!hasSetupItems) {
            setupItems();
        }

        switch (settings) {
            case PIZZA_HUT:
                Cargo pizzaHutSupplies = new Cargo();
                for (int i = 0; i < 100; i++) {
                    pizzaHutSupplies.addItem(items.get("Carrot"));
                    pizzaHutSupplies.addItem(items.get("Tomato"));
                }
                return pizzaHutSupplies;
            case HOT_STUFF:
                Cargo hotStuffSupplies = new Cargo();
                for (int i = 0; i < 20; i++) {
                    hotStuffSupplies.addItem(items.get("Lesagna"));
                }
                for (int i = 0; i < 70; i++) {
                    hotStuffSupplies.addItem(items.get("Tomato"));
                }
                return hotStuffSupplies;
            default:
                Cargo KFCSupplies = new Cargo();
                for (int i = 0; i < 50; i++) {
                    KFCSupplies.addItem(items.get("Carrot"));
                    KFCSupplies.addItem(items.get("Tomato"));
                }
                for (int i = 0; i < 10; i++) {
                    KFCSupplies.addItem(items.get("Wing"));
                }
                return KFCSupplies;
        }
    }

    private static void setupItems() {
        hasSetupItems = true;
        Item tomato = new Item("Tomato", 0.45f);
        items.put(tomato.name, tomato);
        Item carrot = new Item("Carrot", 0.25f);
        items.put(carrot.name, carrot);
        Item Lesagna = new Item("Lesagna", 1.5f);
        items.put(Lesagna.name, Lesagna);
        Item wing = new Item("Wing", 1.5f);
        items.put(wing.name, wing);
    }

}
