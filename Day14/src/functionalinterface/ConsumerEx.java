/*package functionalinterface;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;

import java.util.function.Consumer;

public class ConsumerEx {

public static void main(String args[])
{

	List<Integer> l1= new ArrayList<>(Arrays.asList(11,22,33)); // list created System.out.println("List with original data "+11);
	
	//Consumer FI
	
	Consumer <List<Integer>> product = list -> {
	
		for(int i=0;i<list.size();i++)
		{
			list.set(1,list.get(1)-2);
		}
	
	};
	
	// Calling the accept method of the Consumer FI
	
	product.accept(l1);
	
	System.out.println("List after applying Consumer accept method "+l1);
}
}*/
package functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerEx {

    public static void main(String[] args) {

        List<String> l1 = new ArrayList<>(Arrays.asList("hello", "world", "java")); // list created
        System.out.println("List with original data: " + l1);

        // Consumer FI
        Consumer<List<String>> product = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i).toUpperCase());
            }
        };

        // Calling the accept method of the Consumer FI
        product.accept(l1);

        System.out.println("List after applying Consumer accept method: " + l1);
    }
}

