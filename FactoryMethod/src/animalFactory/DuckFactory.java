package animalFactory;

import animal.Animal;
import animal.Duck;

public class DuckFactory extends AbstractAnimalFactory {
    @Override
    protected Animal animalFactory() {
        return new Duck();
    }
}
