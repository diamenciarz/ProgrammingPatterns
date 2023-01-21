package structural.flyweight;

import java.util.ArrayList;

public class TruckStats {
    private static ArrayList<Cargo> allCargos = new ArrayList<>();

    // Many trucks can share these stats among themselves;
    public Cargo cargo;
    public String model;
    public int productionYear;

    public TruckStats(Cargo cargo, String model, int productionYear) {
        this.model = model;
        this.productionYear = productionYear;

        int cargoIndex = allCargos.indexOf(cargo);
        if (cargoIndex == -1) {
            this.cargo = cargo;
            allCargos.add(cargo);
            return;
        }
        this.cargo = allCargos.get(cargoIndex);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TruckStats)) {
            return false;
        }

        TruckStats stats = (TruckStats) obj;
        if (!stats.model.equals(this.model)) {
            return false;
        }
        if (stats.productionYear != this.productionYear) {
            return false;
        }
        return stats.cargo.equals(this.cargo);
    }
}
