package structural.facade.complex_libraries.translator;

import structural.facade.complex_libraries.Ingredient;
import structural.facade.complex_libraries.StockedIngredient;
import structural.flyweight.Item;
import structural.flyweight.ItemCount;

public class ItemToIngredientTranslator {
    public static StockedIngredient translate(ItemCount itemCount) {
        return new StockedIngredient(new Ingredient(itemCount.item.name), itemCount.count);
    }

    public static StockedIngredient translate(Item item) {
        return new StockedIngredient(new Ingredient(item.name), 1);
    }
}
