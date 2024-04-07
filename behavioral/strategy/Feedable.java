package behavioral.strategy;

import creational.exceptions.FeedingFailedException;
import structural.facade.complex_libraries.Dish;

public interface Feedable {
    public void feed(Dish dish) throws FeedingFailedException; 
}
