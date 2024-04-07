package structural.facade.complex_libraries;

import java.util.ArrayList;

public class Kitchen {
    public enum Preparation {
        COOK,
        FRY,
        DEEP_FRY,
        BAKE,
        SERVE_RAW
    }

    public static PreparedIngredients prepare(StockedIngredients ingredients, Preparation preparation) {
        Ingredient ingredient = ingredients.ingredient;
        int count = ingredients.count;
        switch (preparation) {
            case COOK:
                return new PreparedIngredients(ingredient, count, PreparationWay.COOKED);
            case FRY:
                return new PreparedIngredients(ingredient, count, PreparationWay.FRIED);
            case DEEP_FRY:
                return new PreparedIngredients(ingredient, count, PreparationWay.DEEP_FRIED);
            case BAKE:
                return new PreparedIngredients(ingredient, count, PreparationWay.BAKED);
            default:
                return new PreparedIngredients(ingredient, count, PreparationWay.RAW);
        }
    }

}
