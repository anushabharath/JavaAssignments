package synchronization;
class Thread1 extends Thread
{
    TableCreation obj;
    public Thread1(TableCreation o)
    {
        this.obj = o;
    }
    public void run()
    {
       obj.createTable(10);
    }
}
