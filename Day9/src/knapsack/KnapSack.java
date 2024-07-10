package knapsack;
public class KnapSack
{
    public static int  maximum( int a , int b)
    {
        if(a>b)
            return a;
        else
            return b;
    }
    public static int knapSack(int w, int weight[],int profit[], int n)
    {
        if(n ==0 || w==0)
            return 0;
        if(weight[n-1]>w)
            return knapSack(w,weight,profit,n-1);
        else
            return maximum((profit[n-1]+ knapSack(w-weight[n-1],weight,profit,n-1)), knapSack(w,weight,profit,n-1));
    }
    public static void main(String args[])
    {
        int weight[] = { 50, 90,110,60,100};
        int profit[] = {10,20,30, 10,40};
        int n = 5;
        int w = 250;
        int total = knapSack(w,weight,profit,n);
        System.out.println("Total profit : "+ total);
    }
}