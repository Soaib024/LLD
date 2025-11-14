package animalFactory;

import animal.Animal;
import animal.Tiger;

public class TigerFactory extends AbstractAnimalFactory {
    @Override
    protected Animal animalFactory() {
        return new Tiger();
    }
}
