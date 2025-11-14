package document;

public class Word implements Document{
    @Override
    public void print() {
        System.out.println("Printing word document");
    }

    @Override
    public void delete() {
        System.out.println("Deleting word document");
    }
}
