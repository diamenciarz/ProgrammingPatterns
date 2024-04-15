package behavioral.visitor;

import creational.builder.FoodYield;
import creational.builder.FoodYield.CropType;

public class CarrotField implements Field {
    public FoodYield digUp(){
        return new FoodYield(CropType.CARROT);
    }
    public FoodYield cutOffBush(){
        throw new UnsupportedOperationException("Carrots don't grow on bushes!");
    }
    public FoodYield cutOffStraw(){
        throw new UnsupportedOperationException("Carrots don't grow on straws!");
    }
    public FoodYield pickUp(){
        throw new UnsupportedOperationException("Carrots don't lay on the ground!");
    }

    public void acceptHarvester(VegetableHarvester harvester){
        harvester.harvestCarrots(this);
    }
}
