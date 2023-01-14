package creational.abstract_factory_builder;

public class FactoryTest {
    public static void main(String[] args) {
        System.out.println(FactoryCreator.createAnimal(AnimalSpecies.KWIP).instantiate(CreationSettings.BORING));
        System.out.println(FactoryCreator.createAnimal(AnimalSpecies.KWIP).instantiate(CreationSettings.CHEAP));
        System.out.println(FactoryCreator.createAnimal(AnimalSpecies.KWIP).instantiate(CreationSettings.ELDERLY));
        System.out.println(FactoryCreator.createAnimal(AnimalSpecies.MEEP).instantiate(CreationSettings.PRETTY));
        System.out.println(FactoryCreator.createAnimal(AnimalSpecies.MEEP).instantiate(CreationSettings.RARE));
        System.out.println(FactoryCreator.createAnimal(AnimalSpecies.MEEP).instantiate(CreationSettings.SLIM));
    }
}
