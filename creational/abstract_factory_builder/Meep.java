package creational.abstract_factory_builder;

import java.util.ArrayList;

import structural.chain_of_responsibility.Feedable;
import structural.facade.complex_libraries.Dish;
import structural.facade.complex_libraries.Ingredient;

enum MeepColors {
    BLUE,
    GREEN,
    BLACK
}

public class Meep implements AlienAnimal, Feedable{

    private MeepColors color;
    private int age;
    private float weight;
    private float price;

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

    @Override
    public void feed(Dish dish) {
        Ingredient[] ingredients = listIngredients(dish);
        
    }
}
