package synchronization;

class TableCreation
{
   synchronized public void  createTable(int n)
    {
        for(int i=1;i<=5;i++)
        {
            System.out.println(n+ " * "+ i+ " = "+ n*i);
            try
            {
                Thread.sleep(2000);
            }
            catch(Exception e)
            {
                System.out.println("Thread Interrupted");
            }
        }
    }
}
