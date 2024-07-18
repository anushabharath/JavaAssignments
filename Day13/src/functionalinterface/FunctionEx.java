package functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionEx
{
    public static void main(String args[])
    {
        List<String> li = Arrays.asList("Hi", "Hello"," How ","Oh ");
        System.out.println("Greetings");
        System.out.println(li);
        Function<String,String> adding = s -> s+" !";
        List<String> greetings = li.stream().map(adding).collect(Collectors.toList());
        System.out.println("Greetings with Exclamation");
        System.out.println(greetings);
        
        BiFunction<Integer,Integer,Integer> add = (x,y)-> x+y;
        System.out.println(add.apply(50,40));
        BiFunction<Double,Double,Double> sum = (x,y)-> x+y;
        System.out.println(sum.apply(500.345,400345.67));
    }

}

