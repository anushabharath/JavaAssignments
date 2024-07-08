package bitmanipulation;
 
import java.util.Scanner;
 
public class CountSetBit
{
    public static int brian(int x)
    {
        int r =0;
        while (x > 0)
        {
            x = x & (x-1);
 
                r++;
 
        }
        return r;
    }
    public static int countsetbit(int x)
    {
        int r =0;
        while (x > 0) {
            if ((x & 1)== 1) {
                r++;
            }
           x>>=1;
        }
        return r;
 
    }
    public static void main(String args[])
    {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer");
        n = sc.nextInt();
        System.out.println("Binary representation of n is : "+ Integer.toBinaryString(n));
        System.out.println("Count Set Bit with simple bit manipulation  (right shift) is : "+ countsetbit(n));
 
        System.out.println("Count Set Bit with Brian bit manipulation is : "+ brian(n));
 
 
    }
}
 