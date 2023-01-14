package structural.decorator;

public abstract class CityAddon implements City {

    protected City city;

    public CityAddon(City city) {
        this.city = city;
    }

}
