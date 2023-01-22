package structural.facade.complex_libraries;

import java.util.ArrayList;

import structural.facade.complex_libraries.translator.ItemToIngredientTranslator;
import structural.flyweight.Item;
import structural.flyweight.ItemCount;

public class Magazine {
    private ArrayList<StockedIngredients> ingredientsInStock = new ArrayList<>();

    public StockedIngredients takeIngredient(String ingredientName) throws Exception {
        return takeIngredient(ingredientName, 1);
    }

    public StockedIngredients takeIngredient(String ingredientName, int count) throws Exception {
        int ingredientIndex = findIngredientIndex(ingredientName);
        if (ingredientIndex == -1) {
            throw new Exception("No ingredient" + ingredientName + " in magazine");
        }

        StockedIngredients stockedIngredient = ingredientsInStock.get(ingredientIndex);
        if (stockedIngredient.count < count) {
            throw new Exception("Not enough ingredients " + ingredientName + " in magazine. Asked for" + count
                    + " but have " + stockedIngredient.count);
        }

        stockedIngredient.count -= count;
        return new StockedIngredients(stockedIngredient.ingredient, count);
    }

    public void putIngredient(Item item) {
        putIngredient(new ItemCount(item, 1));
    }

    public void putIngredient(ItemCount itemCount) {
        Ingredient ingredientToFind = ItemToIngredientTranslator.translate(itemCount).ingredient;
        int ingredientIndex = findIngredientIndex(ingredientToFind);

        if (ingredientIndex == -1) {
            StockedIngredients ingredientsToStock = ItemToIngredientTranslator.translate(itemCount);
            ingredientsInStock.add(ingredientsToStock);
            return;
        }

        StockedIngredients stockedIngredient = ingredientsInStock.get(ingredientIndex);
        stockedIngredient.count += itemCount.count;
    }

    private int findIngredientIndex(String ingredientName) {
        return findIngredientIndex(new Ingredient(ingredientName));
    }

    private int findIngredientIndex(Ingredient ingredient) {
        for (int i = 0; i < ingredientsInStock.size(); i++) {
            if (ingredientsInStock.get(i).contains(ingredient)) {
                return i;
            }
        }
        return -1;
    }
}
