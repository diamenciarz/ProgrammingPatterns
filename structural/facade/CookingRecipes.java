package structural.facade;

import java.util.ArrayList;

import structural.facade.complex_libraries.*;
import structural.facade.complex_libraries.Kitchen.Preparation;
import structural.facade.complex_libraries.factories.TruckFactory;
import structural.facade.complex_libraries.factories.TruckFactory.TruckSettings;
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

    // This class is a facade that produces food using recipes.
    // It uses a multitude of classes that allow to control actions in the kitchen.
    // However, the outcome is a cooked meal without the need for the user to worry
    // about the details

    public Dish makeLesagna(boolean withCheese) {
        ensureMagazineStocked(MagazineStock.PIZZA_HUT);

        // Make a Dough, Carrot, and Tomato lesagna
        boolean dishReady = false;
        while (dishReady) {
            try {
                Dish lesagna = new Dish();
                StockedIngredients dough = magazine.takeIngredient("Dough", 2);
                StockedIngredients carrots = magazine.takeIngredient("Carrot", 5);
                StockedIngredients tomatoes = magazine.takeIngredient("Tomato", 10);
                StockedIngredients sauce = magazine.takeIngredient("Sauce", 1);
                // Cook filling

                ArrayList<PreparedIngredient> cookedCarrot = Kitchen.prepare(carrots, Preparation.COOK);
                lesagna.ingredients.addAll(cookedCarrot);
                ArrayList<PreparedIngredient> cookedTomato = Kitchen.prepare(tomatoes, Preparation.COOK);
                lesagna.ingredients.addAll(cookedTomato);
                ArrayList<PreparedIngredient> justSauceNoKetchup = Kitchen.prepare(sauce, Preparation.SERVE_RAW);
                lesagna.ingredients.addAll(justSauceNoKetchup);
                // Add baked dough
                ArrayList<PreparedIngredient> bakedDough = Kitchen.prepare(dough, Preparation.BAKE);
                lesagna.ingredients.addAll(bakedDough);
                dishReady = true;
                return lesagna;

            } catch (Exception e) {
                stockMagazine(TruckSettings.PIZZA_HUT);
            }
        }
        return null;
    }

    public Dish makeStrips(int numberOfPickles) {
        ensureMagazineStocked(MagazineStock.KFC);
        // Make Strips with Carrots and Tomatoes
        boolean dishReady = false;
        while (dishReady) {
            try {
                Dish strips = new Dish();
                StockedIngredients carrots = magazine.takeIngredient("Carrot", 5);
                StockedIngredients tomatoes = magazine.takeIngredient("Tomato", 2);
                StockedIngredients wings = magazine.takeIngredient("Wing", 5);

                // Deep fry wings
                ArrayList<PreparedIngredient> deepFriedWings = Kitchen.prepare(wings, Preparation.DEEP_FRY);
                strips.ingredients.addAll(deepFriedWings);
                // Fry carrots and tomatoes
                ArrayList<PreparedIngredient> friedCarrot = Kitchen.prepare(carrots, Preparation.FRY);
                strips.ingredients.addAll(friedCarrot);
                ArrayList<PreparedIngredient> friedTomato = Kitchen.prepare(tomatoes, Preparation.FRY);
                strips.ingredients.addAll(friedTomato);
                dishReady = true;
                return strips;

            } catch (Exception e) {
                stockMagazine(TruckSettings.KFC);
            }
        }
        return null;
    }

    public Dish makeHotWings(int numberOfPickles) {
        ensureMagazineStocked(MagazineStock.HOT_STUFF);
        // Make Wings with Carrots and Tomatoes
        boolean dishReady = false;
        while (dishReady) {
            try {
                Dish hotWings = new Dish();
                StockedIngredients sauce = magazine.takeIngredient("Sauce", 1);
                StockedIngredients tomatoes = magazine.takeIngredient("Tomato", 3);
                StockedIngredients wings = magazine.takeIngredient("Wing", 7);

                // Bake wings and tomatoes
                ArrayList<PreparedIngredient> bakedWings = Kitchen.prepare(wings, Preparation.BAKE);
                hotWings.ingredients.addAll(bakedWings);
                ArrayList<PreparedIngredient> bakedTomatoes = Kitchen.prepare(tomatoes, Preparation.BAKE);
                hotWings.ingredients.addAll(bakedTomatoes);
                // Add sauce
                ArrayList<PreparedIngredient> rawSauce = Kitchen.prepare(sauce, Preparation.SERVE_RAW);
                hotWings.ingredients.addAll(rawSauce);
                dishReady = true;
                return hotWings;

            } catch (Exception e) {
                stockMagazine(TruckSettings.HOT_STUFF);
            }
        }
        return null;
    }

    private void ensureMagazineStocked(MagazineStock magazineStock) {
        if (magazineStockedFor != magazineStock) {
            stockMagazine(SettingsTranslator.translate(magazineStock));
            magazineStockedFor = magazineStock;
        }
    }

    private void stockMagazine(TruckSettings settings) {
        System.out.println("Stocking magazine with:");
        Truck supplyTruck = TruckFactory.instantiate(settings);
        for (ItemCount itemCount : supplyTruck.getCargo().items) {
            System.out.println(itemCount.count + " of " + itemCount.item.name);
            magazine.putIngredient(itemCount);
        }

    }

    private class SettingsTranslator {
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
