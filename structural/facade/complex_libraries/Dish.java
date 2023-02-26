package structural.facade.complex_libraries;

import java.util.ArrayList;

public class Dish {
    public String name;
    public ArrayList<PreparedIngredient> ingredients = new ArrayList<>();

    public Dish(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String message = name + " contains";
        for (PreparedIngredient preparedIngredient : ingredients) {
            message += " " + preparedIngredient.preparationWay.toString().toLowerCase() + " "
                    + preparedIngredient.ingredient;
        }
        return message;
    }
}
