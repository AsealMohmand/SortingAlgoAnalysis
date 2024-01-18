public class QuickSort {
        static int comp;
        static int move;
        static long time;
    public static void quickSort(int[] list) {
            long start = System.currentTimeMillis();
              quickSort(list, 0, list.length-1);
               long finish = System.currentTimeMillis();
                time = finish-start;
        
               System.out.println("Experimental Results:\nInput Size: " + Runner.size + "\nData Type: " + Runner.dType + "\nSort: Quick\nComparisons: " + comp + "\nMovements: " + move + "\nTime (milli): " + time);
    }
    
    public static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex -1);
            quickSort(list, pivotIndex + 1, last);
            comp++;
        }
    }
    
    /** Partition the array list[first..last] */
    public static int partition(int[] list, int first, int last) {
        int pivot = list[(first+last)/2]; // Choose the first element as the pivot
        int low = first ; // Index for forward search
        int high = last; //Index for backward search
        
        while (high > low) {
            // Search forward from left
            comp++;
            while (low <= high && list[low] <= pivot)
                low++;
            
            // Search backward from right
            while (low <= high && list[high] > pivot)
                high--;
            
            //  Swap two elements in the list
            if (high > low) {
                comp++;
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
                move++;
            }
        }
        
        while (high > first && list[high] >= pivot){
            comp++;
            high--;
        }
        
            //  Swap pivot with list[high]
        if (pivot > list[high]) {
            comp++;
            list[first] = list[high];
            list[high] = pivot; 
            move++;
            return high;
        }
        else {
            return first;
        }
    }
}
