package structural.facade.complex_libraries;

import structural.facade.complex_libraries.factories.CargoFactory;
import structural.facade.complex_libraries.factories.OrderableItemList.AvailableItems;

public class Ingredient {
    public String name;

    public Ingredient(String name) {
        this.name = name;
    }
    public Ingredient(AvailableItems name) {
        this.name = CargoFactory.items.get(name).name;
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
