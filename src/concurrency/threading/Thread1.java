package concurrency.threading;

import java.lang.Thread;

public class Thread1 extends Thread{
    public Thread1(String threadName){
        super(threadName);
    }

    @Override
    public void run() {
        for(int i = 0; i < 6; i++){
            System.out.println("inside: " + Thread1.currentThread().getName() + " " + i);
        }
        // super.run();
    }
}
