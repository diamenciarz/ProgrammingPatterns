package behavioral.visitor;

import creational.builder.FoodYield;

public interface Field {

    public abstract void acceptHarvester(VegetableHarvester harvester);

    public abstract FoodYield digUp();
    public abstract FoodYield cutOffBush();
    public abstract FoodYield cutOffStraw();
    public abstract FoodYield pickUp();
}
