package behavioral.visitor;

import creational.builder.FoodYield;
import creational.builder.FoodYield.CropType;

public class WheatField implements Field {
    public FoodYield digUp(){
        throw new UnsupportedOperationException("Wheat doesn't grow underground!");
    }
    public FoodYield cutOffBush(){
        throw new UnsupportedOperationException("Wheat doesn't grow on bushes!");
    }
    public FoodYield cutOffStraw(){
        return new FoodYield(CropType.WHEAT);
    }
    public FoodYield pickUp(){
        throw new UnsupportedOperationException("Wheat doesn't lay on the ground!");
    }

    public void acceptHarvester(VegetableHarvester harvester){
        harvester.harvestWheat(this);
    }
}
