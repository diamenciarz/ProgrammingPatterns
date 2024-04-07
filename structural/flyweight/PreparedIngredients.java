package structural.flyweight;

import creational.enums.PreparationChoices.PreparationWay;
import structural.data_storage.Ingredient;

public class PreparedIngredients {
    public Ingredient ingredient;
    public PreparationWay preparationWay;
    public int count;

    public PreparedIngredients(Ingredient ingredient, int count, PreparationWay preparationWay) {
        this.ingredient = ingredient;
        this.preparationWay = preparationWay;
        this.count = count;
    }
}
