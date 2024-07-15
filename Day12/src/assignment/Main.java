package assignment;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initial balance of 1000

        Thread t1 = new Thread(new BankTransaction(account, true, 500), "Thread-1");
        Thread t2 = new Thread(new BankTransaction(account, false, 300), "Thread-2");
        Thread t3 = new Thread(new BankTransaction(account, true, 200), "Thread-3");
        Thread t4 = new Thread(new BankTransaction(account, false, 700), "Thread-4");

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final balance
        System.out.println("Final balance: " + account.getBalance());
    }
}

