package structural.facade.complex_libraries;

enum PreparationWay {
    COOKED,
    FRIED,
    DEEP_FRIED,
    BAKED,
    RAW
}

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
