package structural.flyweight;

import java.util.ArrayList;

import javax.swing.text.Position;

public class DrivingTruck {
    // In this scenario we assume that a company has lots of trucks on the road, but
    // their cargo is only one from a few pre-set combinations.
    // The truck's position and fuel value changes by truck,
    // but the truck's cargo and car statistics are shared among the fleet.

    static ArrayList<TruckStats> allTruckStats;

    public Position position;
    public float fuelLiters;
    public String registrationNumber;

    private TruckStats truckStats;

    public DrivingTruck(TruckStats truckStats) {
        int statIndex = allTruckStats.indexOf(truckStats);
        boolean suchStatsDoNotExist = statIndex == -1;
        if (suchStatsDoNotExist) {
            allTruckStats.add(truckStats);
            this.truckStats = truckStats;
        }else{
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
}
