package structural.facade.complex_libraries.factories;

import java.util.Hashtable;

import structural.facade.complex_libraries.Ingredient;
import structural.facade.complex_libraries.factories.OrderableItemList.AvailableItems;
import structural.flyweight.Cargo;
import structural.flyweight.Item;

enum CargoSettings {
    PIZZA_HUT,
    HOT_STUFF,
    KFC
}

public class CargoFactory {

    private static Hashtable<AvailableItems, Item> items = new Hashtable<>();
    private static boolean hasSetupItems = false;

    public static Cargo instantiate(CargoSettings settings) {
        if (!hasSetupItems) {
            setupItems();
        }

        switch (settings) {
            case PIZZA_HUT:
                Cargo pizzaHutSupplies = new Cargo();
                for (int i = 0; i < 100; i++) {
                    pizzaHutSupplies.addItem(items.get(AvailableItems.CARROT));
                    pizzaHutSupplies.addItem(items.get(AvailableItems.TOMATO));
                }
                for (int i = 0; i < 50; i++) {
                    pizzaHutSupplies.addItem(items.get(AvailableItems.SAUCE));
                    pizzaHutSupplies.addItem(items.get(AvailableItems.DOUGH));
                }
                for (int i = 0; i < 25; i++) {
                    pizzaHutSupplies.addItem(items.get(AvailableItems.CHEESE));
                }
                return pizzaHutSupplies;
            case KFC:
                Cargo KFCSupplies = new Cargo();
                for (int i = 0; i < 100; i++) {
                    KFCSupplies.addItem(items.get(AvailableItems.PICKLE));
                }
                for (int i = 0; i < 50; i++) {
                    KFCSupplies.addItem(items.get(AvailableItems.CARROT));
                    KFCSupplies.addItem(items.get(AvailableItems.TOMATO));
                }
                for (int i = 0; i < 10; i++) {
                    KFCSupplies.addItem(items.get(AvailableItems.WING));
                }
                return KFCSupplies;
            default:
                Cargo hotStuffSupplies = new Cargo();
                for (int i = 0; i < 20; i++) {
                    hotStuffSupplies.addItem(items.get(AvailableItems.WING));
                }
                for (int i = 0; i < 70; i++) {
                    hotStuffSupplies.addItem(items.get(AvailableItems.TOMATO));
                    hotStuffSupplies.addItem(items.get(AvailableItems.SAUCE));
                }
                return hotStuffSupplies;
        }
    }

    private static void setupItems() {
        hasSetupItems = true;
        Item tomato = new Item("Tomato", 0.45f);
        items.put(AvailableItems.TOMATO, tomato);
        Item carrot = new Item("Carrot", 0.25f);
        items.put(AvailableItems.CARROT, carrot);
        Item sauce = new Item("Sauce", 0.05f);
        items.put(AvailableItems.SAUCE, sauce);
        Item cheese = new Item("Cheese", 0.5f);
        items.put(AvailableItems.CHEESE, cheese);
        Item dough = new Item("Dough", 0.75f);
        items.put(AvailableItems.DOUGH, dough);
        Item pickle = new Item("Pickle", 0.15f);
        items.put(AvailableItems.PICKLE, pickle);
        Item wing = new Item("Wing", 1.5f);
        items.put(AvailableItems.WING, wing);
    }

    public static Ingredient getIngredient(AvailableItems ingredientName){
        if (!hasSetupItems) {
            setupItems();
        }
        Item item = items.get(ingredientName);
        return new Ingredient(item.name);
    }
    
    public static String getIngredientName(AvailableItems ingredientName){
        if (!hasSetupItems) {
            setupItems();
        }
        Item item = items.get(ingredientName);
        return new Ingredient(item.name).name;
    }
}
