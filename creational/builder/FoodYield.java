package creational.builder;

public class FoodYield {
    public enum CropType{
        CUCUMBER,
        TOMATO,
        CHICKEN,
        MILK,
        CARROT,
        WHEAT
    }

    public FoodYield(CropType type){
        name = type;
    }

    public CropType name;
    public boolean needsWashing;
    public boolean needsCooking;
    public boolean needsDisinfecting;
    public boolean needsCrushing;

    public FoodYield setNeedsWashing(){
        needsWashing = true;
        return this;
    }
    public FoodYield setNeedsCooking(){
        needsCooking = true;
        return this;
    }
    public FoodYield setNeedsDisinfecting(){
        needsDisinfecting = true;
        return this;
    }
    public FoodYield setNeedsCrushing(){
        needsCrushing = true;
        return this;
    }
}
