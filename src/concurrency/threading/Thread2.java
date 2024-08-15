package concurrency.threading;

public class Thread2 implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 6; i++){
            System.out.println("inside: " + Thread1.currentThread().getName() + " " + i);
        }
    }
    
}
