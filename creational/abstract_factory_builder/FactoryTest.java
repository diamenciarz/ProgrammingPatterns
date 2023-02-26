package creational.abstract_factory_builder;

import creational.abstract_factory_builder.AnimalCreationSettings.CreationSettings;
import creational.abstract_factory_builder.exceptions.FeedingFailedException;
import structural.facade.CookingRecipes;
import structural.facade.complex_libraries.Dish;

public class FactoryTest {
    public static void main(String[] args) {
        // System.out.println(FactoryCreator.createAnimal(AnimalSpecies.KWIP).instantiate(CreationSettings.BORING));
        // System.out.println(FactoryCreator.createAnimal(AnimalSpecies.KWIP).instantiate(CreationSettings.CHEAP));
        // System.out.println(FactoryCreator.createAnimal(AnimalSpecies.KWIP).instantiate(CreationSettings.ELDERLY));
        // System.out.println(FactoryCreator.createAnimal(AnimalSpecies.MEEP).instantiate(CreationSettings.PRETTY));
        // System.out.println(FactoryCreator.createAnimal(AnimalSpecies.MEEP).instantiate(CreationSettings.RARE));
        // System.out.println(FactoryCreator.createAnimal(AnimalSpecies.MEEP).instantiate(CreationSettings.SLIM));

        AlienAnimalFactory kwipFactory = FactoryCreator.createAnimal(AnimalSpecies.KWIP);
        AlienAnimalFactory meepFactory = FactoryCreator.createAnimal(AnimalSpecies.MEEP);
        AlienAnimal boringKwip = kwipFactory.instantiate(CreationSettings.BORING);
        AlienAnimal cheapKwip = kwipFactory.instantiate(CreationSettings.CHEAP);
        AlienAnimal elderlyKwip = kwipFactory.instantiate(CreationSettings.ELDERLY);
        AlienAnimal prettyMeep = meepFactory.instantiate(CreationSettings.PRETTY);
        AlienAnimal rareMeep = meepFactory.instantiate(CreationSettings.RARE);
        AlienAnimal slimMeep = meepFactory.instantiate(CreationSettings.SLIM);

        Dish lesagna = CookingRecipes.makeLesagna(false);
        System.out.println(lesagna);

        try {
            boringKwip.feed(lesagna);
        } catch (FeedingFailedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(lesagna);

    }
}
