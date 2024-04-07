package structural.flyweight;

import structural.data_storage.Item;

public class ItemCount {
    public Item item;
    public int count;

    public ItemCount(Item item, int count) {
        this.item = item;
        this.count = count;
    }

    public ItemCount(Item item) {
        this(item, 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ItemCount)) {
            return false;
        }

        ItemCount itemCount = (ItemCount) obj;
        if (itemCount.count != count) {
            return false;
        }
        return itemCount.item.equals(item);
    }
}
