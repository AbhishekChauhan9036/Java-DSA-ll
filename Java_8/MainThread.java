import java.util.*;
import java.io.*;


class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from MyRunnable's implementation of run()");
    }
}
class AnotherThread extends Thread {
    
    @Override
    public void run(){
        System.out.println("Hello from " + currentThread().getName()+" thread!");
    }
}

public class MainThread {
    public static void main (String[] args) throws FileNotFoundException {

        System.out.println("Hello from " + Thread.currentThread().getName()+" thread!");

        /* USING THREAD CLASS*/
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("Another");
        anotherThread.start();
        // anotherThread.run(); // we should never call the run method as it will run the code in the main thread only

        //Anonymous class/thread
        new Thread(){
            public void run(){
                System.out.println("Hello from the anonymous class thread!");
            }
        }.start();
        
        /*USING RUNNABLE INTERFACE */
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        Thread myRunnableThread2 = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println("Hello from MyRunnable's anonymous class's implementation of run()");
            }
        });
        myRunnableThread2.start();


        System.out.println("Hello from main thread again!");

    }
}