package creational.factories;

import java.util.ArrayList;

import structural.facade.complex_libraries.Ingredient;
import creational.enums.AnimalCreationSettings.CreationSettings;
import creational.enums.OrderableItemList.AvailableItems;

public class MeepDietFactory {
    public static ArrayList<Ingredient> instantiate(CreationSettings settings) {
        switch (settings) {
            case ELDERLY:
                ArrayList<Ingredient> elderlyDiet = new ArrayList<>();
                elderlyDiet.add(new Ingredient(AvailableItems.SAUCE));
                elderlyDiet.add(new Ingredient(AvailableItems.WING));
                elderlyDiet.add(new Ingredient(AvailableItems.TOMATO));
                return elderlyDiet;
            case RARE:
                ArrayList<Ingredient> rareDiet = new ArrayList<>();
                rareDiet.add(new Ingredient(AvailableItems.PICKLE));
                rareDiet.add(new Ingredient(AvailableItems.WING));
                return rareDiet;
            case CHEAP:
                ArrayList<Ingredient> cheapDiet = new ArrayList<>();
                cheapDiet.add(new Ingredient(AvailableItems.CARROT));
                cheapDiet.add(new Ingredient(AvailableItems.TOMATO));
                return cheapDiet;
            case PRETTY:
                ArrayList<Ingredient> prettyDiet = new ArrayList<>();
                prettyDiet.add(new Ingredient(AvailableItems.DOUGH));
                prettyDiet.add(new Ingredient(AvailableItems.TOMATO));
                prettyDiet.add(new Ingredient(AvailableItems.CHEESE));
                return prettyDiet;
            case SLIM:
                ArrayList<Ingredient> slimDiet = new ArrayList<>();
                slimDiet.add(new Ingredient(AvailableItems.PICKLE));
                slimDiet.add(new Ingredient(AvailableItems.CARROT));
                slimDiet.add(new Ingredient(AvailableItems.TOMATO));
                return slimDiet;
            default:
                ArrayList<Ingredient> boringDiet = new ArrayList<>();
                boringDiet.add(new Ingredient(AvailableItems.CARROT));
                boringDiet.add(new Ingredient(AvailableItems.TOMATO));
                boringDiet.add(new Ingredient(AvailableItems.CHEESE));
                return boringDiet;
        }
    }
}
