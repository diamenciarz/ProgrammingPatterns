package structural.flyweight;

public class Item {
    public Item(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    public String name;
    public float weight;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Item)) {
            return false;
        }

        Item item = (Item) obj;
        if (!item.name.equals(name)) {
            return false;
        }

        if (item.weight != weight) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + " weights " + weight;
    }
}
