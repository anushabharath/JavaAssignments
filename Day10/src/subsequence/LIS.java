package subsequence;

public class LIS
{
    public static  int lis(int arr[])
    {
        int n = arr.length;
        int lis[] = new int[n];
        for(int i=0;i<n;i++)
            lis[i] = 1;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j] && lis[i]< lis[j] +1)
                    lis[i]= lis[j]+1;
            }

        }
        int m=0;
        for( int i=0;i<n;i++)
        {
            if (m<lis[i])
                m= lis[i];
        }
        return m;

    }
    public static void main(String args[])
    {
        int arr[] = {10, 22, 9, 33, 21, 50, 41,60};
        int length = lis(arr);
        System.out.println("Lenght of the Longest Increasing Subsequence is : "+ length);
    }
}