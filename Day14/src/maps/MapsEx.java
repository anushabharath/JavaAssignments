package maps;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapsEx
{
    public static void main(String args[])
    { // map
        List<String> l1 = Arrays.asList("11","22","33","44");
        List<Double> l3 = l1.stream().map(Double::valueOf).collect(Collectors.toList());
        System.out.println ("Original List : "+l1);
        System.out.println ("List after map operation : "+l3);
       // flatMap
        List<List<Integer>> li = Arrays.asList(Arrays.asList(11,12,13),Arrays.asList(24,34,44),Arrays.asList(23,14,06,30));
        List<Integer>  flat = li.stream().flatMap(a->a.stream()).toList();

        System.out.println ("Original List : "+li);
        System.out.println ("List after map operation : "+flat);

    }
}