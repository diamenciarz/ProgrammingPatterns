package structural.facade.complex_libraries.factories;

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
                for (int i = 0; i < 50; i++) {
                    pizzaHutSupplies.addItem(items.get("Sauce"));
                    pizzaHutSupplies.addItem(items.get("Dough"));
                }
                for (int i = 0; i < 25; i++) {
                    pizzaHutSupplies.addItem(items.get("Cheese"));
                }
                return pizzaHutSupplies;
            case KFC:
                Cargo KFCSupplies = new Cargo();
                for (int i = 0; i < 100; i++) {
                    KFCSupplies.addItem(items.get("Pickle"));
                }
                for (int i = 0; i < 50; i++) {
                    KFCSupplies.addItem(items.get("Carrot"));
                    KFCSupplies.addItem(items.get("Tomato"));
                }
                for (int i = 0; i < 10; i++) {
                    KFCSupplies.addItem(items.get("Wing"));
                }
                return KFCSupplies;
            default:
                Cargo hotStuffSupplies = new Cargo();
                for (int i = 0; i < 20; i++) {
                    hotStuffSupplies.addItem(items.get("Wing"));
                }
                for (int i = 0; i < 70; i++) {
                    hotStuffSupplies.addItem(items.get("Tomato"));
                    hotStuffSupplies.addItem(items.get("Sauce"));
                }
                return hotStuffSupplies;
        }
    }

    private static void setupItems() {
        hasSetupItems = true;
        Item tomato = new Item("Tomato", 0.45f);
        items.put(tomato.name, tomato);
        Item carrot = new Item("Carrot", 0.25f);
        items.put(carrot.name, carrot);
        Item sauce = new Item("Sauce", 0.05f);
        items.put(sauce.name, sauce);
        Item cheese = new Item("Cheese", 0.5f);
        items.put(cheese.name, cheese);
        Item dough = new Item("Dough", 0.75f);
        items.put(dough.name, dough);
        Item pickle = new Item("Pickle", 0.15f);
        items.put(pickle.name, pickle);
        Item wing = new Item("Wing", 1.5f);
        items.put(wing.name, wing);
    }

}
