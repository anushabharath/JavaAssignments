package patternmatching;
public class RKA
{
    static final int prime =101;
    public static void rka(String pat, String txt)
    {
        int m = pat.length();
        int n = txt.length();
        int patHash=0, txtHash =0;
        for(int i=0;i<m;i++)
        {
            patHash = (patHash * prime + pat.charAt(i))% prime;
            txtHash = (patHash * prime + txt.charAt(i))% prime;
        }
        for(int s=0;s<=n-m;s++) {
            if (patHash == txtHash) {
                int j;
                for (j = 0; j < m; j++) {
                    if (txt.charAt(s + j) != pat.charAt(j)) {
                        break;
                    }
                }
                if (j == m)
                    System.out.println("Pattern matched at the index :" + s);
            }
            if (s < n - m)
            {
                txtHash =(txtHash - txt.charAt(s)*pow(prime, m-1))% prime;
                txtHash = (txtHash * prime + txt.charAt(s+m))% prime;
                if(txtHash<0)
                {
                    txtHash += prime; //  txtHash =txtHash+prime;
                }
            }
        }
    }
    static int pow(int base , int ex)
    {
        int r = 1;
        while(ex>0)
        {
          if(ex % 2 == 1)
          {
              r = (r* base)%prime;
          }
          base = (base * base)%prime;
          ex/=2 ; // ex = ex/2;
        }
        return r;
    }
    public static void main(String args[])
    {
        String text = "This is java world";
        String pattern = "java";
        rka(pattern,text);
    }
}
