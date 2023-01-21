package structural.facade;

public class Ingredient {
    public String name;

    @Override
    public boolean equals(Object obj){
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
    public String toString(){
        return  name;
    }

}
