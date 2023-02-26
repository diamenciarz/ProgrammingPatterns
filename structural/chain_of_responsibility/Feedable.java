package structural.chain_of_responsibility;

import creational.abstract_factory_builder.expections.FeedingFailedException;
import structural.facade.complex_libraries.Dish;

public interface Feedable {
    public void feed(Dish dish) throws FeedingFailedException; 
}
