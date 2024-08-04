/*Task 1: Creating and Managing Threads
Write a program that starts two threads, where each thread prints numbers from 1 to 10 with a 1-second delay between each number
*/
package assignment1;

//Define a class that extends Thread
class PrintNumbers extends Thread {
	 private String threadName;
	
	 // Constructor to set the thread name
	 public PrintNumbers(String threadName) {
	     this.threadName = threadName;
	 }
	
	 // Override the run method to specify the thread's task
	 @Override
	 public void run() {
	     for (int i = 1; i <= 10; i++) {
	         System.out.println(threadName + ": " + i);
	         try {
	             Thread.sleep(1000); // Sleep for 1 second
	         } catch (InterruptedException e) {
	             System.out.println(threadName + " interrupted.");
	         }
	     }
	 }
 
 	public static void main(String args[]) {
 
		 // Create two instances of the PrintNumbersThread class
		 PrintNumbers thread1 = new PrintNumbers("Thread-1");
		 PrintNumbers thread2 = new PrintNumbers("Thread-2");
		
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
		
		
		 System.out.println("Both threads have finished execution.");
 	}
}

