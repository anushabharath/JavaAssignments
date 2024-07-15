package intercommunication;

class Share
{
    private int item;
    private boolean isAvailable = false;
    public synchronized void add(int item)
    {
        while(isAvailable) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Interrupted");
            }
        }
        this.item = item;
        isAvailable = true;
        notify();
    }
    public synchronized int reteive()
    {
      while(!isAvailable)
      {
          try
          {
              wait();
          }
          catch(Exception e)
          {
              System.out.println("Interrupted");
          }
      }
      isAvailable = false;
      notify();
      return item;
    }


}

