package animalFactory;

import animal.Animal;
import animal.Duck;
import animal.Tiger;

public class ConcreteAnimalFactory {
    public Animal getAnimal(String animal){
        if (animal == null){
            return null;
        }

        if (animal.equalsIgnoreCase("Duck")){
            return new Duck();
        }

        if (animal.equalsIgnoreCase("Tiger")){
            return new Tiger();
        }

        return null;
    }
}
