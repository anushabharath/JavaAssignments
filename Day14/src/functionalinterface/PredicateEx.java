package functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateEx {
    public static void main(String args[])
    {
		List<String> li = Arrays.asList("Ram", "Shyam","Sita","Sam");
		// predicate to filter the strings starts with 'S'.
		Predicate<String> withS = l1 -> l1.startsWith("S");
		List<String>  names = li.stream().filter(withS).collect(Collectors.toList());
		System.out.println("Names starts with 'S'");
		System.out.println(names);
		// predicate to filter the strings with length greater than 3
		Predicate<String> length = l2 -> l2.length()>2;
		List<String> length3 = li.stream().filter(length).collect(Collectors.toList());
		System.out.println("Names greater than length 2");
		System.out.println(length3);
	}
}
