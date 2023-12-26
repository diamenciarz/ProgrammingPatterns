package structural.decorator;

enum BuildingType {
    BLACKSMITH,
    BARRACKS,
    MARKET
}

public class Building extends CityAddon {

    String name;

    public Building(City castle, BuildingType type) {
        super(castle);
        updateType(type);
    }

    private void updateType(BuildingType type) {
        switch (type) {
            case BARRACKS:
                name = "barracks";
                break;
            case BLACKSMITH:
                name = "a blacksmith";
                break;
            default:
                name = "a market";
                break;
        }
    }

    @Override
    public String toString() {

        return city.toString() + " with " + name;
    }

}
