package creational.abstract_factory;

import creational.enums.AnimalTypes.AnimalSpecies;
import creational.factories.AlienAnimalFactory;
import creational.factories.KwipFactory;
import creational.factories.MeepFactory;



public class FactoryCreator {
    public static AlienAnimalFactory createAnimal(AnimalSpecies species) {
        switch (species) {
            case KWIP:
                return new KwipFactory();
            default:
                return new MeepFactory();
        }
    }
}
