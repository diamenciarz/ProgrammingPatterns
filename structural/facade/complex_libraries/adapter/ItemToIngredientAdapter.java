package structural.facade.complex_libraries.adapter;

import structural.facade.complex_libraries.Ingredient;
import structural.facade.complex_libraries.StockedIngredients;
import structural.flyweight.Item;
import structural.flyweight.ItemCount;

public class ItemToIngredientAdapter {
    public static StockedIngredients translate(ItemCount itemCount) {
        return new StockedIngredients(new Ingredient(itemCount.item.name), itemCount.count);
    }

    public static StockedIngredients translate(Item item) {
        return new StockedIngredients(new Ingredient(item.name), 1);
    }
}
