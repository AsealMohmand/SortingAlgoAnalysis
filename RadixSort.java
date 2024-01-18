import java.io.*;
import java.util.*;

class RadixSort {
    static int comp;
        static int move;
        static long time;
    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++){
            if (arr[i] > mx)
            {
                mx = arr[i];
                move++;
            }
            comp++;
        }
        return mx;
    }

    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
          {  count[i] += count[i - 1];
              move++;
            }
        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            move++;
            count[(arr[i] / exp) % 10]--;
        }
        for (i = 0; i < n; i++)
         {   arr[i] = output[i];
             
            }
    }

    static void radixsort(int arr[], int n) { // Find the maximum number to know number of digits
        long start = System.currentTimeMillis();
        int m = getMax(arr, n);
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
        long finish = System.currentTimeMillis();
        time = finish-start;
        
        System.out.println("Experimental Results:\nInput Size: " + Runner.size + "\nData Type: " + Runner.dType + "\nSort: Radix\nComparisons: " + comp + "\nMovements: " + move + "\nTime (milli): " + time);
    }

    static void print(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
    /**
    public static void main(String[] args) {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = arr.length;
        radixsort(arr, n);
        print(arr, n);
    }
    */
}