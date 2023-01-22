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

    public static ArrayList<PreparedIngredient> prepare(StockedIngredients ingredients, Preparation preparation) {
        PreparedIngredient preparedIngredient = prepare(ingredients.ingredient, preparation);
        ArrayList<PreparedIngredient> preparedIngredients = new ArrayList<>();
        for (int index = 0; index < ingredients.count; index++) {
            preparedIngredients.add(preparedIngredient);
        }
        return preparedIngredients;
    }

    public static PreparedIngredient prepare(Ingredient ingredient, Preparation preparation) {
        switch (preparation) {
            case COOK:
                return new PreparedIngredient(ingredient, PreparationWay.COOKED);
            case FRY:
                return new PreparedIngredient(ingredient, PreparationWay.FRIED);
            case DEEP_FRY:
                return new PreparedIngredient(ingredient, PreparationWay.DEEP_FRIED);
            case BAKE:
                return new PreparedIngredient(ingredient, PreparationWay.BAKED);
            default:
                return new PreparedIngredient(ingredient, PreparationWay.RAW);
        }
    }
}
