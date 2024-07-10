package assignment;

public class BoyerMoore {

    // The function to find the last occurrence of the pattern in the text
    public static int searchLast(String txt, String pat) {
        int[] badChar = new int[256];  // The bad character heuristic table
        int m = pat.length();
        int n = txt.length();

        // Initialize all occurrences as -1
        for (int i = 0; i < 256; i++) {
            badChar[i] = -1;
        }

        // Fill the actual value of last occurrence of a character
        for (int i = 0; i < m; i++) {
            badChar[(int) pat.charAt(i)] = i;
        }

        int s = 0;  // s is the shift of the pattern with respect to the text
        int lastOccurrence = -1; // Variable to store the last occurrence index

        while (s <= (n - m)) {
            int j = m - 1;

            // Keep reducing index j of pattern while characters of pattern and text are matching
            while (j >= 0 && pat.charAt(j) == txt.charAt(s + j)) {
                j--;
            }

            // If the pattern is present at current shift, then update the last occurrence
            if (j < 0) {
                lastOccurrence = s;
                s += (s + m < n) ? m - badChar[txt.charAt(s + m)] : 1;
            } else {
                s += Math.max(1, j - badChar[txt.charAt(s + j)]);
            }
        }

        return lastOccurrence;
    }

    // Driver code
    public static void main(String[] args) {
        String txt = "ABAAABCDABCD";
        String pat = "ABCD";
        
        int result = searchLast(txt, pat);
        
        if (result == -1) {
            System.out.println("Pattern not found in the given text.");
        } else {
            System.out.println("The last occurrence of the pattern is at index " + result);
        }
    }
}

