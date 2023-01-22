package structural.facade.complex_libraries;

enum PreparationWay {
    COOKED,
    FRIED,
    DEEP_FRIED,
    BAKED,
    RAW
}

public class PreparedIngredient {
    public PreparedIngredient(Ingredient ingredient, PreparationWay preparationWay) {
        this.ingredient = ingredient;
        this.preparationWay = preparationWay;
    }

    public Ingredient ingredient;
    public PreparationWay preparationWay;
}
