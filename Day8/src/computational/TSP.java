package computational;

public class TSP{
	   static int n = 4;
	   static int[][] distan = {
	          {0, 20, 42, 25},{20, 0 , 30, 34}, {42, 30, 0, 10}, {25, 34, 10, 0}
	   };
	   static int completed_visit = (1 << n) - 1;
	   static int[][] DP = new int[32][8];
	   static int TSP(int mark, int position) {
	       if (mark == completed_visit) {
	          return distan[position][0];
	       }
	       if (DP[mark][position] != -1) {
	          return DP[mark][position];
	       }
	       int answer = Integer.MAX_VALUE;
	       for (int city = 0; city < n; city++) {
	          if ((mark & (1 << city)) == 0) {
	              int newAnswer = distan[position][city] + TSP(mark | (1 << city), city);
	              answer = Math.min(answer, newAnswer);
	           }
	       }
	       DP[mark][position] = answer;
	      return answer;
	   }
	   public static void main(String[] args) {
	       for (int i = 0; i < (1 << n); i++) {
	          for (int j = 0; j < n; j++) {
	              DP[i][j] = -1;
	           }
	       }
	      System.out.println("Minimum Distance Travelled -> " + TSP(1, 0));
	   }
	}