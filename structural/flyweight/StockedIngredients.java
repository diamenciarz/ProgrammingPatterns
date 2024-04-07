package structural.flyweight;

import structural.data_storage.Ingredient;

public class StockedIngredients {
    public Ingredient ingredient;
    public int count;

    public StockedIngredients(Ingredient ingredient, int count) {
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
