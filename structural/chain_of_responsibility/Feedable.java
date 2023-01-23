package structural.chain_of_responsibility;

import structural.facade.complex_libraries.Dish;

public interface Feedable {
    public void feed(Dish dish);
}
