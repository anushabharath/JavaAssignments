package immutable;

import java.util.concurrent.atomic.AtomicInteger;

class Count
{
    private AtomicInteger c = new AtomicInteger(0);
    public void increment()
    {
      c.incrementAndGet();
    }
    public void decrement()
    {
       c.decrementAndGet();
    }
    public int getTotal()
    {
        return c.get();
    }

}
