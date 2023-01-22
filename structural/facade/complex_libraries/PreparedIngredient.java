package structural.facade.complex_libraries;

enum PreparationWay{
    COOKED,
    FRIED,
    DEEP_FRIED,
    BAKED,
    RAW
}

public class PreparedIngredient {
    public Ingredient ingredient;
    public PreparationWay preparationWay;
}