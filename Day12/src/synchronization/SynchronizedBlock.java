package synchronization;
class Table {
    public void createTable(int n) {
        System.out.println(Thread.currentThread().getName()); // This part is not synchronized.
        synchronized (this) { //  This part is synchronized.
            for (int i = 1; i <= 5; i++) {
                System.out.println(n + " * " + i + " = " + n * i);
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("Thread Interrupted");
                }
            }
        }

    }
}
class Thread11 extends Thread
{
    Table obj;
    public Thread11(Table o)
    {
        this.obj = o;
    }
    public void run()
    {
        obj.createTable(10);
    }
}
class Thread22 extends Thread
{
    Table obj;
    public Thread22(Table o)
    {
        this.obj = o;
    }
    public void run()
    {
        obj.createTable(20);
    }
}

public class SynchronizedBlock{
        public static void main(String [] args)
        {
           Table t = new Table();
            Thread11 t1 = new Thread11(t);
            t1.start();
            Thread22 t2 = new Thread22(t);
            t2.start();
        }
}
