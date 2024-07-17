package lambda; 
interface Operate<T>
{
    //abstract method
    T calculate(T a, T b);

}
class Operations
{
    public static void main(String args[])
    {
        Operate<Integer> rf = (a,b)-> a+b;
       System.out.println( rf.calculate(25,35));
        Operate<Double> rf1 = (a,b)-> a+b;
        System.out.println( rf1.calculate(25.789,35.567));
        Operate<String> rf3 = (a,b)-> a+b;
        System.out.println( rf3.calculate("356","456"));
    }
}
