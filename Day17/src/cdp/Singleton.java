package cdp;
public class Singleton
{
   private static Singleton obj;
   private Singleton() // private Constructor
   {
   }
   public static Singleton getInstance()
   {
       if(obj == null)
       {
           obj = new Singleton();
       }
       return obj;
   }
   public static void main(String args[])
   {
       Singleton instance = Singleton.getInstance();
       System.out.println("Singleton instance "+instance);
       // same object will get created  , As it ensures that only one object is created.
       Singleton in = Singleton.getInstance();
       System.out.println("Singleton instance "+in);
   }
}

