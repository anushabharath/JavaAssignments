package creating;

public class Demo1 extends Thread{
	
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println(Thread.currentThread()+"-------------"+i+ " ");
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				System.out.println("Thread Interruped");
			}
		}
	}
	public static void main(String args[]) {
		Demo1 t1 = new Demo1();
		Demo1 t2 = new Demo1();
		t1.start();
		t2.start();
	}

}
