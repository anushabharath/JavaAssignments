package assignment;

class ThreadStateDemo {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Task(), "Thread-1");

        // State: NEW (Before start)
        System.out.println(t1.getName() + " state before start(): " + t1.getState());

        // Start the thread
        t1.start();

        // State: RUNNABLE (After start)
        System.out.println(t1.getName() + " state after start(): " + t1.getState());

        // State: TIMED_WAITING (During sleep)
        Thread.sleep(100); // Allowing thread t1 to enter TIMED_WAITING state
        System.out.println(t1.getName() + " state during sleep(): " + t1.getState());

        // State: BLOCKED (Thread trying to enter synchronized block while another thread holds the lock)
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " acquired the lock.");
                try {
                    Thread.sleep(2000); // Hold the lock for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-2");

        synchronized (lock) {
            t2.start();
            Thread.sleep(100); // Ensure t2 tries to enter synchronized block and gets blocked
            System.out.println(t2.getName() + " state while blocked: " + t2.getState());
        }

        // Ensure t1 is completed before main thread exits
        t1.join();
        t2.join();

        // State: TERMINATED (After completion)
        System.out.println(t1.getName() + " state after completion: " + t1.getState());
        System.out.println(t2.getName() + " state after completion: " + t2.getState());
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                // State: TIMED_WAITING
                System.out.println(Thread.currentThread().getName() + " going to sleep.");
                Thread.sleep(1000);

                synchronized (lock) {
                    // State: WAITING
                    System.out.println(Thread.currentThread().getName() + " waiting for lock.");
                    lock.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock) {
                // Notifying other waiting threads
                lock.notify();
            }
        }
    }
}
