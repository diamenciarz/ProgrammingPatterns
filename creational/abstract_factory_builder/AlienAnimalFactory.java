package creational.abstract_factory_builder;

import creational.abstract_factory_builder.AnimalCreationSettings.CreationSettings;

public interface AlienAnimalFactory {
    AlienAnimal instantiate(CreationSettings settings);
}

