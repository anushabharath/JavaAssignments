package recursion;

public class SubSet
{

    static boolean isSubSet(int set[],int n, int sum)
    {
        if(sum==0)
            return true;
        if(n==0 && sum!=0)
            return false;
        if(set[n-1]>sum)
            return isSubSet(set,n-1,sum);

        return(isSubSet(set,n-1,sum-set[n-1]) || isSubSet(set,n-1,sum));

    }
    public static void main(String args[])

    {
        int set[] ={1, 9, 7, 5, 18, 12, 20, 15};
        int sum  = 35;
        int n = set.length;
        if(isSubSet(set,n,sum))
            System.out.println("Subset is present");
        else
            System.out.println("SubSet Not present");

    }
}
