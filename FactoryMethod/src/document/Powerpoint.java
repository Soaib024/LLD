package document;

public class Powerpoint implements Document{
    @Override
    public void print() {
        System.out.println("Printing powerpoint document");
    }

    @Override
    public void delete() {
        System.out.println("Deleting powerpoint document");
    }
}
