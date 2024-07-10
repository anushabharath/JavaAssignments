package assignment;

public class KMPAlgorithm {
    
    public static void KMPSearch(String pattern, String text) {
        int M = pattern.length();
        int N = text.length();
        
        // Create lps[] that will hold the longest prefix suffix values for pattern
        int[] lps = new int[M];
        int j = 0; // index for pattern
        
        // Preprocess the pattern (calculate lps[] array)
        computeLPSArray(pattern, M, lps);
        
        int i = 0; // index for text
        while (i < N) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            
            if (j == M) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            }
            // mismatch after j matches
            else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters, they will match anyway
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
    }
    
    public static void computeLPSArray(String pattern, int M, int[] lps) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0
        
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        KMPSearch(pattern, text);
    }
}

