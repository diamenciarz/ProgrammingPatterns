package creational.factories;

import java.util.ArrayList;
import java.util.Hashtable;

import creational.enums.OrderableItemList.AvailableItems;
import structural.flyweight.Cargo;
import structural.flyweight.Ingredient;
import structural.flyweight.Item;
import structural.flyweight.ItemCount;

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
        ArrayList<ItemCount> itemCounts = new ArrayList<>();

        switch (settings) {
            case PIZZA_HUT:
                itemCounts.add(new ItemCount(items.get(AvailableItems.CARROT), 100));
                itemCounts.add(new ItemCount(items.get(AvailableItems.TOMATO), 100));
                itemCounts.add(new ItemCount(items.get(AvailableItems.SAUCE), 50));
                itemCounts.add(new ItemCount(items.get(AvailableItems.DOUGH), 50));
                itemCounts.add(new ItemCount(items.get(AvailableItems.CHEESE), 25));

                Cargo pizzaHutSupplies = new Cargo(itemCounts);
                return pizzaHutSupplies;
                
            case KFC:
                itemCounts.add(new ItemCount(items.get(AvailableItems.PICKLE), 100));
                itemCounts.add(new ItemCount(items.get(AvailableItems.CARROT), 50));
                itemCounts.add(new ItemCount(items.get(AvailableItems.TOMATO), 50));
                itemCounts.add(new ItemCount(items.get(AvailableItems.WING), 10));

                Cargo KFCSupplies = new Cargo(itemCounts);
                return KFCSupplies;
                
            default:
                itemCounts.add(new ItemCount(items.get(AvailableItems.WING), 20));
                itemCounts.add(new ItemCount(items.get(AvailableItems.TOMATO), 70));
                itemCounts.add(new ItemCount(items.get(AvailableItems.SAUCE), 70));

                Cargo hotStuffSupplies = new Cargo(itemCounts);
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
