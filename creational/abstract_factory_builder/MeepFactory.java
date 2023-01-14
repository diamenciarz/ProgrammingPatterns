package creational.abstract_factory_builder;

public class MeepFactory implements AlienAnimalFactory {
    public Meep instantiate(CreationSettings settings) {
        switch (settings) {
            case BORING:
                return new Meep(MeepColors.GREEN, 100);
            case ELDERLY:
                return new Meep(MeepColors.BLUE, 70).setAge(73);
            case RARE:
                return new Meep(MeepColors.BLACK, 50).setPrice(100);
            case CHEAP:
                return new Meep(MeepColors.GREEN, 15).setPrice(1);
            case PRETTY:
                return new Meep(MeepColors.BLUE, 30).setPrice(55).setAge(18);
            case SLIM:
                return new Meep(MeepColors.GREEN, 12).setPrice(22).setAge(12);
            default:
                return new Meep(MeepColors.GREEN, 100);
        }
    }
}