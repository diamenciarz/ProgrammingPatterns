package creational.abstract_factory_builder;

enum AnimalSpecies {
    KWIP,
    MEEP
}

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
