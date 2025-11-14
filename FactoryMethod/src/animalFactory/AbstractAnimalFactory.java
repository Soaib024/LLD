package animalFactory;

import animal.Animal;

public abstract class AbstractAnimalFactory {
    protected abstract Animal animalFactory();
    public Animal getAnimal(){
        return animalFactory();
    }
}
