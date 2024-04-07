package structural.flyweight;

import java.util.ArrayList;

import creational.factories.CargoFactory;
import creational.enums.OrderableItemList.AvailableItems;
import structural.adapter.ItemToIngredient;
import structural.data_storage.Ingredient;
import structural.data_storage.Item;

public class Magazine {
    private ArrayList<StockedIngredients> ingredientsInStock = new ArrayList<>();

    public StockedIngredients takeIngredient(AvailableItems ingredientName) throws Exception {
        return takeIngredient(ingredientName, 1);
    }

    public StockedIngredients takeIngredient(AvailableItems ingredientName, int count) throws Exception {
        int ingredientIndex = findIngredientIndex(ingredientName);
        if (ingredientIndex == -1) {
            throw new Exception("No  " + ingredientName + " in magazine");
        }

        StockedIngredients stockedIngredient = ingredientsInStock.get(ingredientIndex);
        if (stockedIngredient.count < count) {
            throw new Exception("Not enough " + ingredientName + " in magazine. Asked for" + count
                    + " but have " + stockedIngredient.count);
        }

        stockedIngredient.count -= count;
        return new StockedIngredients(stockedIngredient.ingredient, count);
    }

    public void putIngredient(Item item) {
        putIngredient(new ItemCount(item, 1));
    }

    public void putIngredient(ItemCount itemCount) {
        Ingredient ingredientToFind = ItemToIngredient.translate(itemCount).ingredient;
        int ingredientIndex = findIngredientIndex(ingredientToFind);

        if (ingredientIndex == -1) {
            StockedIngredients ingredientsToStock = ItemToIngredient.translate(itemCount);
            ingredientsInStock.add(ingredientsToStock);
            return;
        }

        StockedIngredients stockedIngredient = ingredientsInStock.get(ingredientIndex);
        stockedIngredient.count += itemCount.count;
    }

    private int findIngredientIndex(AvailableItems ingredientName) {
        return findIngredientIndex(CargoFactory.getIngredient(ingredientName));
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
