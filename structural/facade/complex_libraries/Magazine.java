package structural.facade.complex_libraries;

import java.util.ArrayList;

public class Magazine {
    private ArrayList<StockedIngredient> ingredientsInStock = new ArrayList<>();

    public void takeIngredient(Ingredient ingredient) throws Exception {
        takeIngredient(ingredient, 1);
    }

    public void takeIngredient(Ingredient ingredient, int count) throws Exception {
        int ingredientIndex = findIngredientIndex(ingredient);
        if (ingredientIndex == -1) {
            throw new Exception("No ingredient" + ingredient + " in magazine");
        }

        StockedIngredient stockedIngredient = ingredientsInStock.get(ingredientIndex);
        if (stockedIngredient.count <= 0) {
            throw new Exception("No ingredient" + ingredient + " in magazine");
        }

        stockedIngredient.count -= count;
    }

    public void putIngredient(Ingredient ingredient) throws Exception {
        putIngredient(ingredient, 1);
    }

    public void putIngredient(Ingredient ingredient, int count) throws Exception {
        int ingredientIndex = findIngredientIndex(ingredient);
        if (ingredientIndex == -1) {
            StockedIngredient ingredientToStock = new StockedIngredient(ingredient, count);
            ingredientsInStock.add(ingredientToStock);
        }

        StockedIngredient stockedIngredient = ingredientsInStock.get(ingredientIndex);
        stockedIngredient.count += count;
    }

    private int findIngredientIndex(Ingredient ingredient) {
        for (int i = 0; i < ingredientsInStock.size(); i++) {
            if (ingredientsInStock.get(i).contains(ingredient)) {
                return i;
            }
        }
        return -1;
    }

    private class StockedIngredient {
        public Ingredient ingredient;
        public int count;

        public StockedIngredient(Ingredient ingredient, int count) {
            this.ingredient = ingredient;
            this.count = count;
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Ingredient)) {
                return false;
            }

            Ingredient ingredient = (Ingredient) obj;
            return ingredient.equals(this.ingredient);
        }
    }
}
