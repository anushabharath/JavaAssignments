package synchronization;
public class Main
{
    public static void main(String args[])
    {
        TableCreation object = new TableCreation();
        Thread1 t1 = new Thread1(object);
        Thread2 t2 = new Thread2(object);
        t1.start();
        t2.start();
    }
}
