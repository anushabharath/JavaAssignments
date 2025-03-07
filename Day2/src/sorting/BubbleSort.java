package sorting;

public class BubbleSort {
    static void bubbleSort(int[] arr) {
        
        int temp = 0;
        for(int i=0; i < arr.length; i++){
            for(int j=1; j < arr.length-1-i; j++){
            	
                if(arr[j-1] > arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }
    
    public static void main(String[] args) {
        int arr[] ={15,16,6,8,5};

        System.out.println("Array Before Bubble Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        bubbleSort(arr);

        System.out.println("Array After Bubble Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
