package structural.flyweight;

import java.util.ArrayList;


public class Truck {
    // In this scenario we assume that a company has lots of trucks on the road, but
    // their cargo is only one from a few pre-set combinations.
    // The truck's position and fuel value changes by truck,
    // but the truck's cargo and car statistics are shared among the fleet.

    static ArrayList<TruckStats> allTruckStats = new ArrayList<>();

    private Position position;
    public float fuelLiters = 120;
    public String registrationNumber;

    private TruckStats truckStats;

    public Truck(TruckStats truckStats, Position startingPosition, String registration) {
        this.position = startingPosition;
        this.registrationNumber = registration;

        int statIndex = allTruckStats.indexOf(truckStats);
        boolean suchStatsDoNotExist = statIndex == -1;
        if (suchStatsDoNotExist) {
            allTruckStats.add(truckStats);
            this.truckStats = truckStats;
        } else {
            truckStats = allTruckStats.get(statIndex);
        }
    }

    public Cargo getCargo() {
        return truckStats.cargo;
    }

    public String getModel() {
        return truckStats.model;
    }

    public int getProductionYear() {
        return truckStats.productionYear;
    }

    public Position getPosition() {
        return position;
    }

    public void moveTo(Position targetPosition) {
        position.moveTo(targetPosition);
    }

    public void moveBy(Position deltaPosition) {
        position.moveBy(deltaPosition);
    }
}
