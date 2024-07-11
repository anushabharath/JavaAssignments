package subsequence;

public class LCS
{
 
  public static int lcs(char[]x,char[]y,int m, int n )
  {
       int [][]l = new int[m+1][n+1];
       for(int i=0;i<=m;i++)
       {
           for(int j=0;j<=n;j++)
           {
               if(i==0 || j==0)
                   l[i][j]=0;
               else if(x[i-1]==y[j-1])
                  l[i][j] = l[i-1][j-1]+1;
               else
                   l[i][j] = Math.max(l[i-1][j],l[i][j-1]);
 
          }
       }
     return l[m][n];
  }
 
  public static void main(String args[])
  {
       String s1 = "abccba";
       String s2 = "abddba";
 
       char f [] = s1.toCharArray();
       char s[] = s2.toCharArray();
       int m = s1.length();
       int n = s2.length();
      int  lon = lcs(f,s,m,n);
       System.out.println("The longest subsequence is : "+lon);
       }
}
