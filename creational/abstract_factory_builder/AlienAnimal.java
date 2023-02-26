package creational.abstract_factory_builder;

import structural.chain_of_responsibility.Feedable;

public interface AlienAnimal extends Feedable {
    @Override
    public String toString();
}