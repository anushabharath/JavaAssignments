package backtracking;
import java.util.ArrayList;
import java.util.List;
public class RatInMaze
{
static String direction = "DLRU";
static int[] dr = {1,0,0,-1};
static int[]dc = {0,-1,1,0};
public static boolean isValid(int r, int c, int n, int[][] maze)
{
    return r>=0 && c>=0  && r<n && c<n && maze[r][c]==1;
}

public static void findPath(int r, int c, int n, int[][] maze, List<String> res,StringBuilder cp)
{
    if(r ==n-1 && c==n-1) {
        res.add(cp.toString());
        return;
    }
    maze[r][c] =0 ;
    for(int i=0;i<n-1;i++)
    {
        int  nextr = r+dr[i];
        int nextc = c+dc[i];
        if(isValid(nextr,nextc,n,maze))
        {
            cp.append(direction.charAt(i)); // appending cp(currentpath)
            findPath(nextr,nextc,n,maze,res,cp); // calling the findPath()
            cp.deleteCharAt(cp.length()-1);// backtracking

        }

    }
    maze[r][c]= 1;

}

    public static void main(String args[])
    {
        int maze[][] = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        int n = maze.length;
        List<String> res = new ArrayList<>();
        StringBuilder cp = new StringBuilder();
        if(maze[0][0]!=0 && maze[n-1][n-1] !=0)
            findPath(0,0,n,maze,res,cp);
        if(res.isEmpty())
            System.out.println(-1-1);
        else
            for(String p : res)
                System.out.println(p+ " ");
            System.out.println(" ");
             }
}