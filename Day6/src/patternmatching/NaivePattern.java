package patternmatching;
 
public class NaivePattern
{
   public static void npm(String t, String p)
   {
       int m = p.length();
       int n = t.length();
       for(int i=0;i<=n-m;i++) {
           int j;
           for (j = 0; j < m; j++)
           {
               if (t.charAt(i + j) != p.charAt(j))
                   break;
           }
 
           if (j == m)
               System.out.println("Pattern matched at index " + i);
       }
 
 
   }
   public static void main(String args[])
   {
       String text = "aabasbaddaaabffeaad";
       String pattern = "aab";
       npm(text,pattern);
 
   }
}
