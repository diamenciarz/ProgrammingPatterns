package creational.abstract_factory_builder;

import structural.chain_of_responsibility.Feedable;
import structural.facade.complex_libraries.Dish;

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

    @Override
    public void feed(Dish dish){
        String message = dish.toString();
        String ingredient = findMostPopularIngredient(message);
        
    }
}
