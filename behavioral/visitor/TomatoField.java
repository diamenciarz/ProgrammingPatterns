package behavioral.visitor;

import creational.builder.FoodYield;
import creational.builder.FoodYield.CropType;

public class TomatoField implements Field {

    public FoodYield digUp(){
        throw new UnsupportedOperationException("Tomatoes cannot be dug up!");
    }
    public FoodYield cutOffBush(){
        return new FoodYield(CropType.TOMATO);
    }
    public FoodYield cutOffStraw(){
        throw new UnsupportedOperationException("Tomatoes don't grow on straws!");
    }
    public FoodYield pickUp(){
        throw new UnsupportedOperationException("Tomatoes dont lay on the ground!");
    }

    public void acceptHarvester(VegetableHarvester harvester){
        harvester.harvestTomatoes(this);
    }
}
