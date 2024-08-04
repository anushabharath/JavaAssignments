/*
Task 2: States and Transitions
Create a Java class that simulates a thread going through different lifecycle states: NEW, RUNNABLE, WAITING, TIMED_WAITING, BLOCKED, and TERMINATED. Use methods like sleep(), wait(), notify(), and join() to demonstrate these states..
*/
package assignment2;

class MyThread implements Runnable {
    public void run() {
        // Moving thread to timed waiting state
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("State of thread1 while it called join() method on thread2: " + Thread.currentThread().getState());

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadLifecycleDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);

        // Thread1 is currently in the NEW state
        System.out.println("State of thread1 after creation: " + thread1.getState());

        // Start thread1
        thread1.start();

        // Thread1 is now in the RUNNABLE state
        System.out.println("State of thread1 after starting: " + thread1.getState());

        // Wait for thread1 to complete
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Thread1 is now in the TERMINATED state
        System.out.println("State of thread1 after joining: " + thread1.getState());
    }
}
