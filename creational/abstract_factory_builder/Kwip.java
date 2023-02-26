package creational.abstract_factory_builder;

import java.util.ArrayList;

import creational.abstract_factory_builder.exceptions.FeedingFailedException;
import structural.chain_of_responsibility.Feedable;
import structural.facade.complex_libraries.Dish;
import structural.facade.complex_libraries.Ingredient;
import structural.facade.complex_libraries.PreparedIngredient;

enum KwipShape {
    BALL,
    CUBE,
    TETRAHEDRON
}

enum KwipSexuality {
    OROROSEXUAL,
    TERASEXUAL,
    CAPITALIST
}

public class Kwip implements AlienAnimal, Feedable {

    private KwipShape shape;
    private int dimension;
    private KwipSexuality sexuality;
    private float price;

    public Kwip(KwipShape shape, int dimension) {
        this.shape = shape;
        this.dimension = dimension;
        this.sexuality = KwipSexuality.OROROSEXUAL;
        this.price = 2000000;
    }

    public Kwip setSexuality(KwipSexuality sexuality) {
        this.sexuality = sexuality;
        return this;
    }

    public Kwip setPrice(int price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return sexuality.toString() + " Kwip is a " + shape + " lives in the " + dimension
                + " dimension, and costs $" + price + ".";
    }

    /**
     * Kwips only eat the common ingredients from a dish. If multiple ingredients
     * are the most common, they will not eat anything
     * and will throw an exception. The dish will be untouched afterwards
     */
    @Override
    public void feed(Dish dish) throws FeedingFailedException {
        checkDishValidity(dish);

        Ingredient ingredient = findMostPopularIngredient(dish);
        eatChosenIngredientFromDish(dish, ingredient);
    }

    private void checkDishValidity(Dish dish) throws FeedingFailedException {
        boolean dishIsWronglyDefined = dish.ingredients == null;
        boolean dishIsEmpty = dish.ingredients.size() == 0;
        if (dishIsEmpty) {
            throw new FeedingFailedException("Dish was empty");
        }
        if (dishIsWronglyDefined) {
            throw new FeedingFailedException("Dish was wrongly defined. The list of ingredients was null");
        }

    }

    private Ingredient findMostPopularIngredient(Dish dish) throws FeedingFailedException {
        IngredientCounts ingredientCounts = listIngredients(dish);
        int highestCount = 0;
        int index = -1;
        boolean twoWithSameCount = false;

        for (int i = 0; i < ingredientCounts.counts.size(); i++) {
            int currentCount = ingredientCounts.counts.get(i);
            if (currentCount == highestCount) {
                twoWithSameCount = true;
            }
            if (currentCount > highestCount) {
                highestCount = currentCount;
                index = i;
                twoWithSameCount = false;
            }
        }

        if (twoWithSameCount) {
            throw new FeedingFailedException(
                    "Dish contained two most common ingredients that occured with the same count");
        }
        return (ingredientCounts.ingredients.get(index));
    }

    private IngredientCounts listIngredients(Dish dish) {
        IngredientCounts ingredientCounts = new IngredientCounts();
        for (PreparedIngredient preparedIngredient : dish.ingredients) {
            ingredientCounts.add(preparedIngredient.ingredient);
        }
        return ingredientCounts;
    }

    private void eatChosenIngredientFromDish(Dish dish, Ingredient ingredientToEat) {
        for (PreparedIngredient preparedIngredientInDish : dish.ingredients) {
            if (preparedIngredientInDish.ingredient == ingredientToEat) {
                dish.ingredients.remove(preparedIngredientInDish);
            }
        }
    }

    private class IngredientCounts {
        public ArrayList<Ingredient> ingredients = new ArrayList<>();
        public ArrayList<Integer> counts = new ArrayList<>();

        public boolean contains(Ingredient ingredient) {
            for (Ingredient ingredientInList : ingredients) {
                if (ingredientInList == ingredient) {
                    return true;
                }
            }
            return false;
        }

        public void add(Ingredient ingredient) {
            for (int i = 0; i < ingredients.size(); i++) {
                if (ingredients.get(i) == ingredient) {
                    counts.set(i, counts.get(i) + 1);
                    return;
                }
            }
            ingredients.add(ingredient);
            counts.add(1);
        }
    }
}
