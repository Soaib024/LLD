package concurrency.threading;

public class MainThread {
    public static void main(String[] args) {
        System.err.println("Starting Main Thread");
        Thread1 thread1 = new Thread1("t1");
        thread1.start();

        Thread thread2 = new Thread(new Thread2(), "t2");
        thread2.start();


        System.err.println("Ending Main Thread");

    }
}
