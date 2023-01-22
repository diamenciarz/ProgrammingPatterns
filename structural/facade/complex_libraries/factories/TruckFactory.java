package structural.facade.complex_libraries.factories;

import structural.flyweight.Position;
import structural.flyweight.Truck;
import structural.flyweight.TruckStats;

public class TruckFactory {
    public enum TruckSettings {
        PIZZA_HUT,
        HOT_STUFF,
        KFC
    }

    public static Truck instantiate(TruckSettings settings) {
        switch (settings) {
            case PIZZA_HUT:
                TruckStats stats1 = new TruckStats(CargoFactory.instantiate(CargoSettings.PIZZA_HUT), "BMW Epic", 2000);
                return new Truck(stats1, new Position(20, 20), "Rock Man");
            case HOT_STUFF:
                TruckStats stats2 = new TruckStats(CargoFactory.instantiate(CargoSettings.HOT_STUFF), "Skoda fabia",
                        2018);
                return new Truck(stats2, new Position(45, 40), "Skoda, das auto");
            default:
                TruckStats stats3 = new TruckStats(CargoFactory.instantiate(CargoSettings.KFC), "Fabulous VW", 2022);
                return new Truck(stats3, new Position(-10000, -100), "VW simply clever");
        }
    }
}
