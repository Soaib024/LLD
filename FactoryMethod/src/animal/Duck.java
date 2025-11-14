package animal;

public class Duck implements Animal {
    @Override
    public void walk() {
        System.out.println("animal.Duck is walking");
    }

    @Override
    public void eat() {
        System.out.println("animal.Duck is eating");
    }
}