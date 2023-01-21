package structural.flyweight;

import java.util.ArrayList;
import java.util.LinkedList;

public class Cargo {
    private ArrayList<ItemCount> items = new ArrayList<>();

    public Cargo() {

    }

    public Cargo(ArrayList<ItemCount> items) {
        this.items = items;
    }

    public boolean contains(ItemCount itemCount) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(itemCount)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cargo)) {
            return false;
        }

        Cargo cargo = (Cargo) obj;
        if (cargo.items.size() != items.size()) {
            return false;
        }
        for (int i = 0; i < items.size(); i++) {
            if (!cargo.contains(items.get(i))) {
                return false;
            }
        }
        return true;
    }

    private float totalWeight;
    private boolean isTotalWeightUpToDate = false;

    public float getTotalWeight() {
        if (isTotalWeightUpToDate) {
            return totalWeight;
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

        for (ItemCount itemCount : items) {
            total += itemCount.count * itemCount.item.weight;
        }
        return total;
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

        for (ItemCount itemCount : items) {
            names.add(itemCount.item.name);
        }
        return new ArrayList<String>(names);
    }

    public void addItem(Item item) {
        areItemNamesUpToDate = false;
        isTotalWeightUpToDate = false;

        for (int i = 0; i < items.size(); i++) {
            ItemCount itemCount = items.get(i);
            if (itemCount.item.equals(item)) {
                itemCount.count++;
                return;
            }
        }
        items.add(new ItemCount(item));
    }
}
