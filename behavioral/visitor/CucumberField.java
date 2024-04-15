package behavioral.visitor;

import creational.builder.FoodYield;
import creational.builder.FoodYield.CropType;

public class CucumberField implements Field {
    public FoodYield digUp(){
        throw new UnsupportedOperationException("Cucumbers don't grow underground!");
    }
    public FoodYield cutOffBush(){
        throw new UnsupportedOperationException("Cucumbers don't grow on bushes!");
    }
    public FoodYield cutOffStraw(){
        throw new UnsupportedOperationException("Cucumbers don't grow on straws!");
    }
    public FoodYield pickUp(){
        return new FoodYield(CropType.CUCUMBER);
    }

    public void acceptHarvester(VegetableHarvester harvester){
        harvester.harvestCucumbers(this);
    }
}
