package searching;
import java.util.*;
public class JumpSearch {

	public static int performSearch (int[] a, int target) {
	
		int m = (int) Math.floor(Math.sqrt(a.length));
		
		int currentLastIndex = m-1;
		
		while(currentLastIndex <a.length && target > a[currentLastIndex]) {
			currentLastIndex  +=m;
		
		}
		
		
		for(int i= currentLastIndex-m+1; i<=currentLastIndex && i< a.length; i++) {
		
			 if(target == a[i]) {
				 return i;
			 }
		
		}
		return -1;

	}
	
	public static void main(String[] args) {
	
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		
		int target = 12;
		
		JumpSearch jump = new JumpSearch(); 
		int index = jump.performSearch(a, target);
		
		System.out.println("Number found at index: "+index);
	}
}