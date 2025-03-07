package pattern;
class BoyerMoore {
    static int NO_OF_CHARS = 256;

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Function to create the bad character heuristic table
    static void badCharHeuristic(char[] str, int size, int[] badchar) {
        // Initialize all occurrences as -1
        for (int i = 0; i < NO_OF_CHARS; i++)
            badchar[i] = -1;

        // Fill the actual value of the last occurrence of a character
        for (int i = 0; i < size; i++)
            badchar[(int) str[i]] = i;
    }

    // Function to search for pattern in text using the Boyer-Moore algorithm
    static void search(char[] txt, char[] pat) {
        int m = pat.length;
        int n = txt.length;

        int[] badchar = new int[NO_OF_CHARS];

        // Fill the bad character array by calling the preprocessing function
        badCharHeuristic(pat, m, badchar);

        int s = 0; // s is the shift of the pattern with respect to text
        while (s <= (n - m)) {
            int j = m - 1;

            // Keep reducing index j of pattern while characters of pattern and text are matching at this shift s
            while (j >= 0 && pat[j] == txt[s + j])
                j--;

            // If the pattern is present at the current shift, then index j will become -1 after the above loop
            if (j < 0) {
                System.out.println("Pattern occurs at shift = " + s);

                // Shift the pattern so that the next character in text aligns with the last occurrence of it in pattern
                // The condition s+m < n is necessary for the case when pattern occurs at the end of text
                s += (s + m < n) ? m - badchar[txt[s + m]] : 1;
            } else {
                // Shift the pattern so that the bad character in text aligns with the last occurrence of it in pattern
                s += max(1, j - badchar[txt[s + j]]);
            }
        }
    }

    public static void main(String[] args) {
        char txt[] = "ABAAABCD".toCharArray();
        char pat[] = "ABC".toCharArray();
        search(txt, pat);
    }
}
