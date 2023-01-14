package structural.flyweight;

import java.util.ArrayList;
import java.util.LinkedList;

public class Cargo {
    public Cargo() {

    }

    public Cargo(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cargo)) {
            return false;
        }

        Cargo cargo = (Cargo) obj;
        for (int i = 0; i < items.size(); i++) {
            if (!cargo.items.get(i).equals(this.items.get(i))) {
                return false;
            }
        }

        return true;
    }

    private ArrayList<Item> items = new ArrayList<>();

    private float totalWeight;
    private boolean isTotalWeightUpToDate = false;

    public float getTotalWeight() {
        if (isTotalWeightUpToDate) {
            return this.totalWeight;
        }
        updateTotalWeight();
        return totalWeight;
    }

    private void updateTotalWeight() {
        totalWeight = calculateTotalWeight();
        isTotalWeightUpToDate = true;
    }

    private float calculateTotalWeight() {
        float total = 0;

        for (Item item : items) {
            total += item.weight;
        }
        return total;
    }

    public void addItem(Item item) {
        areItemNamesUpToDate = false;
        isTotalWeightUpToDate = false;
        items.add(item);
    }

    private ArrayList<String> itemNames;
    private boolean areItemNamesUpToDate = false;

    public ArrayList<String> getItemNames() {
        if (areItemNamesUpToDate) {
            return itemNames;
        }

        updateAllNames();
        return itemNames;
    }

    private void updateAllNames() {
        itemNames = findAllNames();
        areItemNamesUpToDate = true;
    }

    private ArrayList<String> findAllNames() {
        LinkedList<String> names = new LinkedList<>();

        for (Item item : items) {
            if (!names.contains(item.name)) {
                names.add(item.name);
            }
        }
        return new ArrayList<String>(names);
    }
}
