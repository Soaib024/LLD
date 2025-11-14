package animal;

public class Tiger implements Animal {
    @Override
    public void walk() {
        System.out.println("animal.Tiger is walking");
    }

    @Override
    public void eat() {
        System.out.println("animal.Tiger is eating");
    }
}