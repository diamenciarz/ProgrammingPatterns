package creational.factories;

import creational.AlienAnimal;
import creational.enums.AnimalCreationSettings;
import creational.enums.AnimalCreationSettings.CreationSettings;

public interface AlienAnimalFactory {
    AlienAnimal instantiate(CreationSettings settings);
}

