package intercommunication;

public class Main
{
    public static void main(String args[])
    {
       Share  share = new Share();
       Producer producer = new Producer(share);
       Consumer consumer = new Consumer(share);
       producer.start();
       consumer.start();
    }
}