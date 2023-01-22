package structural.facade.complex_libraries.translator;

import structural.facade.complex_libraries.Ingredient;
import structural.facade.complex_libraries.StockedIngredients;
import structural.flyweight.Item;
import structural.flyweight.ItemCount;

public class ItemToIngredientTranslator {
    public static StockedIngredients translate(ItemCount itemCount) {
        return new StockedIngredients(new Ingredient(itemCount.item.name), itemCount.count);
    }

    public static StockedIngredients translate(Item item) {
        return new StockedIngredients(new Ingredient(item.name), 1);
    }
}
