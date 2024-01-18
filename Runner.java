
/**
 * Write a description of class Runner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import static java.lang.System.*; 
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Runner
{
    // instance variables - replace the example below with your own
    public static int arr[];
    public static int  size;
    public static String dType;
    public static void main(String args[])
    {
        createArr();
        sort();
        
    }

    public static void createArr()
    {
        //finds out how ordered the list is
        System.out.println("1. InOrder\n"   + "2. ReverseOrder\n" +  "3. AlmostOrder\n"   + "4. Random Order\n" +  "List Properties, select the data type of list you wish to use: ");
             Scanner kb = new Scanner(System.in);
            int order = kb.nextInt();
            
        //finds out how big the list is and sets it
        System.out.println("1. 5000\n"   + "2. 15000\n" +  "3. 50000\n"    + "Input Size, select the size of the list: ");
             size = kb.nextInt();
            if(size == 1) size = 5000;
            if(size == 2) size = 15000;
            if(size == 3) size = 50000;
          arr = new int[size];   
          
        //puts random ints in
            Random rd = new Random();
            for( int i = 0; i< arr.length; i++)
            {
                arr[i] = (int)(Math.random()*(size-2))+1;
            }
            //System.out.println(Arrays.toString(arr)); This was for making sure the array was made correctly
            //System.out.println(arr.length);
            
            //puts in correct order
            if(order ==1)
            { //inorder
                dType = "InOrder";
                for (int j = 1; j < arr.length; j++) {
            //i just used the insertion sort
            int currentElement = arr[j];
            int k;
            for (k = j-1; k>= 0 && arr[k] > currentElement; k--) {
                arr[k+1] = arr[k];
            }
            
            //insert the current element into list[k + 1]
            arr[k + 1] = currentElement;
            
            
        }
        //System.out.println(Arrays.toString(arr));
            }
             if(order ==2)
             {//reverse order
                int temp;
                dType = "ReverseOrder";
                for (int i = 0; i < arr.length; i++) {     
                    for (int j = i+1; j < arr.length; j++) {     
                        if(arr[i] < arr[j]) {    
                            temp = arr[i];    
                            arr[i] = arr[j];    
                            arr[j] = temp;    
                        }     
                    }  
               }
        //System.out.println(Arrays.toString(arr));
            }
             if(order ==3)
            {//almost order (20%)
                dType = "AlmostOrder";
                for(int i = 0; i < (size*.2); i++)
                {
                    int temp1 =(int) (Math.random()*(arr.length-2)+1);
                    int temp2 =(int) (Math.random()*(arr.length-2)+1);
                    
                    if(temp1 < temp2)
                    {
                        if(arr[temp1] > arr[temp2])
                        {
                           int tempAs = arr[temp1];
                           arr[temp1]= arr[temp2];
                           arr[temp2] = tempAs;
                        }
                    }
                     if(temp1 > temp2)
                    {
                        if(arr[temp1] <arr[temp2])
                       {
                        int tempAs = arr[temp1];
                        arr[temp1] = arr[temp2];
                        arr[temp2] = tempAs;
                      }  
                    }
                    
                    
                }
                //System.out.println(Arrays.toString(arr));
            }
            if(order==4){dType = "RandomOrder";}//random order
            //System.out.println(Arrays.toString(arr));
    }
    public static String sort()
    {
        //chooses sort and uses it
        System.out.println("1. Insertion Sort\n"   + "2. Selection Sort\n" +  "3. Quick Sort\n"   + "4. Merge Sort\n" +  "5. Heap Sort\n" + "6. Radix Sort\n" + "Sorting Algorithm, select the sorting algorithm: ");
            Scanner kb = new Scanner(System.in);
            int algo = kb.nextInt();
            if(algo == 1) //Insertion sort
            {
                InsertionSort.insertionSort(arr);
            }
             if(algo == 2)//selection sort
            {
                SelectionSort.selectionSort(arr);
            }
             if(algo == 3)//quick sort
            {
                QuickSort.quickSort(arr);
            }
             if(algo == 4) //merge sort
            {
                long start = System.currentTimeMillis();
                MergeSort.mergeSort(arr);
                long finish = System.currentTimeMillis();
                MergeSort.time = finish-start;
                System.out.println("Experimental Results:\nInput Size: " +size + "\nData Type: " + dType + "\nSort: Merge\nComparisons: " + MergeSort.comp + "\nMovements: " + MergeSort.move + "\nTime (milli): " + MergeSort.time);
            }
             if(algo == 5) //heap sort
            {
                //convert array to set
               Integer arrN[] = new Integer[size];
               for(int i = 0; i < size; i++)
               { arrN[i] = arr[i];
                }
                HeapSort.heapSort(arrN);
            }
             if(algo == 6) //radix sort
            {
                RadixSort.radixsort(arr,size);
            }
        return "";
    }
    
   
}
