package structural.flyweight;

public class TruckStats {
    // Many trucks can share these stats among themselves;
    public Cargo cargo;
    public String model;
    public int productionYear;

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

        if (stats.cargo.equals(this.cargo)) {
            return false;
        }

        return true;
    }
}
