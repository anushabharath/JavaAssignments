package patternmatching;
public class KMP
{
    public static void kmp(String pa, String txt) {
        int m = pa.length();
        int n = txt.length();
        int[] ps = new int[m];
        computeps(pa,m,ps);
        int i=0; // for text array.
        int j=0; // for pattern array
        while(i<n)
        {
            if(pa.charAt(j)==txt.charAt(i))
            {
                i++;
                j++;
            }
            if(j==m)
            {
                System.out.println("Pattern matched at index :"+(i-j));
                j= ps[j-1];

            }
            else if(i<n && pa.charAt(j)!=txt.charAt(i))
            {
                if(j!=0)
                {
                    j= ps[j-1];
                }
                else {
                    i++;
                }
            }
        }
    }
    public static void computeps(String pa,int m, int []ps)
    {
       int len =0;
       ps[0]=0;
       int i=1;
       while(i<m)
       {
         if(pa.charAt(i)==pa.charAt(len))
         {
             len++;
             ps[i]=len;
             i++;
             }
         else {
             if(len!=0)
             {
                 len= ps[len-1];
             }
             else {
                 ps[i] =0;
                 i++;
             }
         }
       }


    }
    public static void main(String args[])
    {
        String text = "aabasaaabbaddaaabffeaad";
        String pattern = "aab";
        kmp(pattern,text);
    }
}