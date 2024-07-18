package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx {

    public static void main(String args[]) {

        List<Integer> num = Arrays.asList(23, 14, 30, 6);

        List<Integer> even = num.stream()
                                .filter(n -> n % 2 == 0)
                                .collect(Collectors.toList());

        System.out.println("Even Numbers: " + even);

        int total = even.stream()
                        .mapToInt(Integer::intValue)
                        .sum();

        System.out.println("Total Value: " + total);

        // Corrected and complete the List of Double values
        List<Double> num1 = Arrays.asList(4.14, 14.67, 30.67, 6.89);

        List<Double> doubledValues = num1.stream()
                                         .map(n -> n * 2)
                                         .collect(Collectors.toList());

        System.out.println("Doubled Values: " + doubledValues);

        double totalDouble = doubledValues.stream()
                                          .mapToDouble(Double::doubleValue)
                                          .sum();

        System.out.println("Total Double Value: " + totalDouble);
    }
}
