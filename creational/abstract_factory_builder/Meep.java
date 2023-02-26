package creational.abstract_factory_builder;

import java.util.ArrayList;

import creational.abstract_factory_builder.expections.FeedingFailedException;
import structural.chain_of_responsibility.Feedable;
import structural.facade.complex_libraries.Dish;
import structural.facade.complex_libraries.Ingredient;
import structural.facade.complex_libraries.PreparedIngredient;

enum MeepColors {
    BLUE,
    GREEN,
    BLACK
}

public class Meep implements AlienAnimal, Feedable {

    private MeepColors color;
    private int age;
    private float weight;
    private float price;
    private ArrayList<Ingredient> diet;

    public Meep(MeepColors color, float weight) {
        this.color = color;
        this.weight = weight;
        this.age = 1;
        this.price = 10;
    }

    public Meep setPrice(float price) {
        this.price = price;
        return this;
    }

    public Meep setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return color.toString() + " Meep is " + age + " years old, weights " + weight + " and costs $" + price + ".";
    }

    public void setDiet(ArrayList<Ingredient> edibleIngredients) {
        diet = edibleIngredients;
    }

    /**
     * Meeps check what is their diet and if all ingredients of a dish are present
     * in their diet, they accept the meal.
     * If an ingredient of a dish is not present in a Meep's diet, it will throw a
     * IllegalIngredient exception.
     */
    @Override
    public void feed(Dish dish) throws FeedingFailedException {
        Ingredient[] ingredients = listIngredients(dish);

        if (!containsIllegalIngredient(ingredients)) {
            consume(dish);
        }
    }

    private Ingredient[] listIngredients(Dish dish) {
        ArrayList<Ingredient> rawIngredients = new ArrayList<>();
        for (PreparedIngredient preparedIngredient : dish.ingredients) {
            rawIngredients.add(preparedIngredient.ingredient);
        }
        return rawIngredients.toArray(new Ingredient[0]);
    }

    private boolean containsIllegalIngredient(Ingredient[] ingredients) throws FeedingFailedException {
        for (Ingredient ingredient : ingredients) {
            boolean ingredientNotInDiet = !diet.contains(ingredient);
            if (ingredientNotInDiet) {
                throw new FeedingFailedException(
                        "Dish was not eaten by a Meep, because it contained an illegal ingredient " + ingredient);
            }
        }
        return false;
    }

    private void consume(Dish dish) {
        dish.ingredients = new ArrayList<>();
        dish.name = "";
    }
}
