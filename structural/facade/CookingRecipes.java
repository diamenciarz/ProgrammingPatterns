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

    }

    public Dish makeHotWings(int numberOfPickles) {
        ensureMagazineStocked(MagazineStock.HOT_STUFF);

    }

    private void ensureMagazineStocked(MagazineStock magazineStock) {
        if (magazineStockedFor != magazineStock) {
            stockMagazine(SettingsTranslator.translate(magazineStock));
            magazineStockedFor = magazineStock;
        }
    }

    private void stockMagazine(TruckSettings settings) {
        Truck supplyTruck = TruckFactory.instantiate(settings);
        for (ItemCount itemCount : supplyTruck.getCargo().items) {
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
