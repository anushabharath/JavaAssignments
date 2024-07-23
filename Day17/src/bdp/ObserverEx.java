package bdp;

public class ObserverEx
{
    public static void main(String args[])
    {
        MessageSubscriber1 s1 = new MessageSubscriber1();
        MessageSubscriber2 s2 = new MessageSubscriber2();
        MessageSubscriber3 s3 = new MessageSubscriber3();
        MessagePublisher p = new MessagePublisher();
        p.attach(s1);
        p.attach(s2);
        p.notifyUpdate(new Message("This is the First Message")); // s1 and s2 receives the update
        p.attach(s3);
        p.detach(s1); // s1 removed
        p.notifyUpdate(new Message("This is Second Message")); // s2 and s3 receives the update

    }

}
