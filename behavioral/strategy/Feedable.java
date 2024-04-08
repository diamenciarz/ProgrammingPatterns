package behavioral.strategy;

import creational.exceptions.FeedingFailedException;
import structural.data_storage.Dish;

public interface Feedable {
    public void feed(Dish dish) throws FeedingFailedException; 
}
