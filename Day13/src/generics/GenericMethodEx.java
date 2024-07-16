package generics;

public class GenericMethodEx
{
    public static <T> void show(T[] x)
    {
       for(T val:x)
           System.out.print(val+" ");
    }
    public static void main(String[] args)
    {
        String arr[] = {"sgf","hscdsj","hc","qw6qw"};
        Integer p [] = {1,4,7,8,0,3};
        show(p);
        System.out.println(" ");
        show(arr);    }
}
