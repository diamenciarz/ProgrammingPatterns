package structural.data_storage;

import java.util.ArrayList;
import structural.flyweight.PreparedIngredients;

public class Dish {
    public String name;
    public ArrayList<PreparedIngredients> ingredients = new ArrayList<>();

    public Dish(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String message = name + " contains";
        for (PreparedIngredients preparedIngredient : ingredients) {
            message += String.format(" %d %s %s,", preparedIngredient.count,
                    preparedIngredient.preparationWay.toString().toLowerCase(), preparedIngredient.ingredient);
        }
        return message;
    }
}
