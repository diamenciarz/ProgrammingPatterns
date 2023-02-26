package creational.abstract_factory_builder;

import creational.abstract_factory_builder.AnimalCreationSettings.CreationSettings;
import structural.facade.CookingRecipes;

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

        System.out.println(CookingRecipes.makeLesagna(false));

        
    }
}
