package structural.decorator;

enum PersonType {
    ARCHER,
    MERCHANT,
    BANKER
}

public class Person extends CityAddon {

    String name;

    public Person(City city, PersonType type) {
        super(city);
        updateName(type);
    }

    private void updateName(PersonType type) {
        switch (type) {
            case ARCHER:
                name = "an archer";
            case MERCHANT:
                name = "a merchant";
            default:
                name = "a banker";
        }
    }

    @Override
    public String toString() {
        return city.toString() + " with " + name;
    }

}
