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
        return item.name.equals(name) && item.weight == weight;
    }

    @Override
    public String toString() {
        return name + " weights " + weight;
    }
}
