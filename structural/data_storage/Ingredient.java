package structural.data_storage;

import creational.factories.CargoFactory;
import creational.enums.OrderableItemList.AvailableItems;

public class Ingredient {
    public String name;

    public Ingredient(String name) {
        this.name = name;
    }
    public Ingredient(AvailableItems name) {
        this.name = CargoFactory.getIngredientName(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Ingredient)) {
            return false;
        }

        Ingredient ingredient = (Ingredient) obj;
        if (!ingredient.name.equals(this.name)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}
