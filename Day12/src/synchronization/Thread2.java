package synchronization;
class Thread2 extends Thread
{
    TableCreation obj;
    public Thread2(TableCreation o)
    {
        this.obj = o;
    }
    public void run()
    {
        obj.createTable(20);
    }
}

