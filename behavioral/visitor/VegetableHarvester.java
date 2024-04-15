package behavioral.visitor;

import creational.builder.FoodYield;

public class VegetableHarvester {
    public FoodYield harvestTomatoes(TomatoField field){
        return field.cutOffBush();
    }
    public FoodYield harvestCarrots(CarrotField field){
        return field.digUp();
    }
    public FoodYield harvestCucumbers(CucumberField field){
        return field.pickUp();
    }
    public FoodYield harvestWheat(WheatField field){
        return field.cutOffStraw();
    }
}
