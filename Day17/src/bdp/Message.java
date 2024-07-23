package bdp;

import java.util.ArrayList;
import java.util.List;

interface Subject
{
    public void attach(Observer O);
    public void detach(Observer o);
    public void notifyUpdate(Message m);
}
interface Observer
{
    public void update(Message m);
}
class Message
{
    String messagecontent;

    public Message(String messagecontent) {
        this.messagecontent = messagecontent;
    }

    public String getMessagecontent() {
        return messagecontent;
    }

}

class MessagePublisher implements Subject
{
    private List<Observer> l1 = new ArrayList<>();
    public void attach(Observer o)
    {
        l1.add(o);
    }
    public void detach(Observer o)
    {
        l1.remove(o);
    }
    public void notifyUpdate(Message m)
    {
        for(Observer ob : l1)
            ob.update(m);
    }
}
class MessageSubscriber1 implements Observer
{
    public void update(Message o)
    {
        System.out.println("Message Subscriber 1 :"+ o.getMessagecontent());
    }

}
class MessageSubscriber2 implements Observer
{
    public void update(Message o)
    {
        System.out.println("Message Subscriber 2 :"+ o.getMessagecontent());
    }

}
class MessageSubscriber3 implements Observer
{
    public void update(Message o)
    {
        System.out.println("Message Subscriber 3 :"+ o.getMessagecontent());
    }

}
