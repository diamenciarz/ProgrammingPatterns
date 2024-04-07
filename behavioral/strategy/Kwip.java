package behavioral.strategy;

import creational.enums.KweepProperties.KwipSexuality;
import creational.enums.KweepProperties.KwipShape;
import creational.exceptions.FeedingFailedException;
import structural.facade.complex_libraries.Dish;
import structural.flyweight.Ingredient;
import structural.flyweight.PreparedIngredients;

public class Kwip implements AlienAnimal {

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
        int highestCount = 0;
        int index = -1;
        boolean twoWithSameCount = false;
        for (int i = 0; i < dish.ingredients.size(); i++) {
            PreparedIngredients ingredient = dish.ingredients.get(i);

            if (ingredient.count == highestCount) {
                twoWithSameCount = true;
            }
            if (ingredient.count > highestCount) {
                highestCount = ingredient.count;
                index = i;
                twoWithSameCount = false;
            }
        }
        if (twoWithSameCount) {
            throw new FeedingFailedException(
                    "Dish contained two most common ingredients that occured with the same count");
        }
        return dish.ingredients.get(index).ingredient;
    }

    private void eatChosenIngredientFromDish(Dish dish, Ingredient ingredientToEat) {
        for (int i = dish.ingredients.size() - 1; i >= 0; i--) {
            PreparedIngredients preparedIngredientInDish = dish.ingredients.get(i);
            if (preparedIngredientInDish.ingredient == ingredientToEat) {
                dish.ingredients.remove(preparedIngredientInDish);
            }
        }
    }
}
