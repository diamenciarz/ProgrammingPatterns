package structural.facade;

import java.util.ArrayList;

import creational.factories.TruckFactory;
import creational.enums.OrderableItemList.AvailableItems;
import creational.factories.TruckFactory.TruckSettings;
import structural.facade.complex_libraries.*;
import structural.facade.complex_libraries.Kitchen.Preparation;
import structural.flyweight.ItemCount;
import structural.flyweight.Truck;

enum MagazineStock {
    PIZZA_HUT,
    HOT_STUFF,
    KFC
}

public class CookingRecipes {
    private static MagazineStock magazineStockedFor;
    private static Magazine magazine = new Magazine();

    public static void main(String[] args) {
        Dish wings = makeHotWings();
        System.out.println(wings);
    }

    // This class is a facade that produces food using recipes.
    // It uses a multitude of classes that allow to control actions in the kitchen.
    // However, the outcome is a cooked meal without the need for the user to worry
    // about the details

    public static Dish makeLesagna(boolean withCheese) {
        ensureMagazineStocked(MagazineStock.PIZZA_HUT);

        // Make a Dough, Carrot, and Tomato lesagna
        boolean dishReady = false;
        while (!dishReady) {
            try {
                Dish lesagna = new Dish("Lesagna");
                StockedIngredients dough = magazine.takeIngredient(AvailableItems.DOUGH, 2);
                StockedIngredients carrots = magazine.takeIngredient(AvailableItems.CARROT, 5);
                StockedIngredients tomatoes = magazine.takeIngredient(AvailableItems.TOMATO, 6);
                StockedIngredients sauce = magazine.takeIngredient(AvailableItems.SAUCE, 1);
                StockedIngredients cheese = magazine.takeIngredient(AvailableItems.CHEESE, 1);
                // Cook filling

                PreparedIngredients cookedCarrot = Kitchen.prepare(carrots, Preparation.BAKE);
                lesagna.ingredients.add(cookedCarrot);
                PreparedIngredients cookedTomato = Kitchen.prepare(tomatoes, Preparation.COOK);
                lesagna.ingredients.add(cookedTomato);
                PreparedIngredients justSauceNoKetchup = Kitchen.prepare(sauce, Preparation.SERVE_RAW);
                lesagna.ingredients.add(justSauceNoKetchup);
                // Add baked dough
                PreparedIngredients bakedDough = Kitchen.prepare(dough, Preparation.BAKE);
                lesagna.ingredients.add(bakedDough);

                if (withCheese) {
                    PreparedIngredients bakedCheese = Kitchen.prepare(cheese, Preparation.BAKE);
                    lesagna.ingredients.add(bakedCheese);
                }

                dishReady = true;
                return lesagna;

            } catch (Exception e) {
                stockMagazine(TruckSettings.PIZZA_HUT);
            }
        }
        return null;
    }

    public static Dish makeStrips(int numberOfPickles) {
        ensureMagazineStocked(MagazineStock.KFC);
        // Make Strips with Carrots and Tomatoes
        boolean dishReady = false;
        while (!dishReady) {
            try {
                Dish strips = new Dish("Chicken strips");
                StockedIngredients carrots = magazine.takeIngredient(AvailableItems.CARROT, 5);
                StockedIngredients tomatoes = magazine.takeIngredient(AvailableItems.TOMATO, 2);
                StockedIngredients wings = magazine.takeIngredient(AvailableItems.WING, 5);
                StockedIngredients pickles = magazine.takeIngredient(AvailableItems.PICKLE, numberOfPickles);

                // Deep fry wings
                PreparedIngredients deepFriedWings = Kitchen.prepare(wings, Preparation.DEEP_FRY);
                strips.ingredients.add(deepFriedWings);
                // Fry carrots and tomatoes
                PreparedIngredients friedCarrot = Kitchen.prepare(carrots, Preparation.FRY);
                strips.ingredients.add(friedCarrot);
                PreparedIngredients friedTomato = Kitchen.prepare(tomatoes, Preparation.FRY);
                strips.ingredients.add(friedTomato);
                // Add raw pickles
                PreparedIngredients rawPickles = Kitchen.prepare(pickles, Preparation.SERVE_RAW);
                strips.ingredients.add(rawPickles);

                dishReady = true;
                return strips;

            } catch (Exception e) {
                stockMagazine(TruckSettings.KFC);
            }
        }
        return null;
    }

    public static Dish makeHotWings() {
        ensureMagazineStocked(MagazineStock.HOT_STUFF);
        // Make Wings with Carrots and Tomatoes
        boolean dishReady = false;
        while (!dishReady) {
            try {
                Dish hotWings = new Dish("Hot wings");
                StockedIngredients sauce = magazine.takeIngredient(AvailableItems.SAUCE, 1);
                StockedIngredients tomatoes = magazine.takeIngredient(AvailableItems.TOMATO, 3);
                StockedIngredients wings = magazine.takeIngredient(AvailableItems.WING, 7);

                // Bake wings and tomatoes
                PreparedIngredients bakedWings = Kitchen.prepare(wings, Preparation.BAKE);
                hotWings.ingredients.add(bakedWings);
                PreparedIngredients bakedTomatoes = Kitchen.prepare(tomatoes, Preparation.BAKE);
                hotWings.ingredients.add(bakedTomatoes);
                // Add sauce
                PreparedIngredients rawSauce = Kitchen.prepare(sauce, Preparation.SERVE_RAW);
                hotWings.ingredients.add(rawSauce);
                dishReady = true;
                return hotWings;

            } catch (Exception e) {
                stockMagazine(TruckSettings.HOT_STUFF);
            }
        }
        return null;
    }

    private static void ensureMagazineStocked(MagazineStock magazineStock) {
        if (magazineStockedFor != magazineStock) {
            stockMagazine(SettingsTranslator.translate(magazineStock));
            magazineStockedFor = magazineStock;
        }
    }

    private static void stockMagazine(TruckSettings settings) {
        System.out.println("Stocking magazine with:");
        Truck supplyTruck = TruckFactory.instantiate(settings);
        for (ItemCount itemCount : supplyTruck.getCargo().items) {
            System.out.println(itemCount.count + " of " + itemCount.item.name);
            magazine.putIngredient(itemCount);
        }

    }

    private static class SettingsTranslator {
        public static TruckSettings translate(MagazineStock magazineStock) {
            switch (magazineStock) {
                case HOT_STUFF:
                    return TruckSettings.HOT_STUFF;
                case KFC:
                    return TruckSettings.KFC;
                default:
                    return TruckSettings.PIZZA_HUT;
            }
        }
    }

}
