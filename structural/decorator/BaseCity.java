package structural.decorator;

enum CitySpecialization {
    FISHING,
    FARMING,
    BUSINESS
}

public class BaseCity implements City {
    private String specialization;

    public BaseCity(CitySpecialization specialization) {
        updateSpecialization(specialization);
    }

    private void updateSpecialization(CitySpecialization type) {
        switch (type) {
            case FISHING:
                specialization = "This is a fishing-oriented city";
            case FARMING:
                specialization = "This is farming-oriented city";
            default:
                specialization = "This is business-oriented city";
        }
    }

    @Override
    public String toString() {
        return specialization.toString();
    }

    public static void main(String[] args) {
        PersonType a = PersonType.ARCHER;
        System.out.println(new Person(new Person(new Building(new BaseCity(CitySpecialization.BUSINESS), BuildingType.MARKET), a), a));
        System.out.println(new BaseCity(CitySpecialization.FARMING));
    }
}
