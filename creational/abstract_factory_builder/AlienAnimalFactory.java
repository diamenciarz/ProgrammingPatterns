package creational.abstract_factory_builder;

enum CreationSettings {
    BORING,
    ELDERLY,
    RARE,
    CHEAP,
    PRETTY,
    SLIM
}

public interface AlienAnimalFactory {
    AlienAnimal instantiate(CreationSettings settings);
}

