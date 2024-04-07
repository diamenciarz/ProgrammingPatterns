package creational.factories;

import behavioral.strategy.AlienAnimal;
import creational.enums.AnimalCreationSettings.CreationSettings;

public interface AlienAnimalFactory {
    AlienAnimal instantiate(CreationSettings settings);
}

