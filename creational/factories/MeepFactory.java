package creational.factories;

import java.util.ArrayList;

import behavioral.strategy.Meep;
import creational.enums.AnimalCreationSettings.CreationSettings;
import creational.enums.MeepProperties.MeepColors;
import structural.data_storage.Ingredient;

public class MeepFactory implements AlienAnimalFactory {
    public Meep instantiate(CreationSettings settings) {
        switch (settings) {
            case ELDERLY:
                ArrayList<Ingredient> elderlyDiet = MeepDietFactory.instantiate(CreationSettings.ELDERLY);
                return new Meep(MeepColors.BLUE, 70).setAge(73).setDiet(elderlyDiet);
            case RARE:
                ArrayList<Ingredient> rareDiet = MeepDietFactory.instantiate(CreationSettings.RARE);
                return new Meep(MeepColors.BLACK, 50).setPrice(100).setDiet(rareDiet);
            case CHEAP:
                ArrayList<Ingredient> cheapDiet = MeepDietFactory.instantiate(CreationSettings.CHEAP);
                return new Meep(MeepColors.GREEN, 15).setPrice(1).setDiet(cheapDiet);
            case PRETTY:
                ArrayList<Ingredient> prettyDiet = MeepDietFactory.instantiate(CreationSettings.PRETTY);
                return new Meep(MeepColors.BLUE, 30).setPrice(55).setAge(18).setDiet(prettyDiet);
            case SLIM:
                ArrayList<Ingredient> slimDiet = MeepDietFactory.instantiate(CreationSettings.SLIM);
                return new Meep(MeepColors.GREEN, 12).setPrice(22).setAge(12).setDiet(slimDiet);
            default:
                ArrayList<Ingredient> boringDiet = MeepDietFactory.instantiate(CreationSettings.BORING);
                return new Meep(MeepColors.GREEN, 100).setDiet(boringDiet);
        }
    }
}