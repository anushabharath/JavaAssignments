package assignment;

class NumberPrinter extends Thread {
    private String threadName;

    NumberPrinter(String name) {
        threadName = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(threadName + " - Number: " + i);
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted.");
        }
    }

    public static void main(String[] args) {
        // Create two threads
        NumberPrinter thread1 = new NumberPrinter("Thread 1");
        NumberPrinter thread2 = new NumberPrinter("Thread 2");

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Main thread finished.");
    }
}
