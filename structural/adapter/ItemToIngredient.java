package structural.adapter;

import structural.data_storage.Ingredient;
import structural.data_storage.Item;
import structural.flyweight.ItemCount;
import structural.flyweight.StockedIngredients;

public class ItemToIngredient {
    public static StockedIngredients translate(ItemCount itemCount) {
        return new StockedIngredients(new Ingredient(itemCount.item.name), itemCount.count);
    }

    public static StockedIngredients translate(Item item) {
        return new StockedIngredients(new Ingredient(item.name), 1);
    }
}
