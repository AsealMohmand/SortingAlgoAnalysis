
public class InsertionSort {
    /**The method for sorting the numbers */
    static int comp;
    static int move;
    static long time;
    public static void insertionSort(int[] list) {
        long start = System.currentTimeMillis();
        for (int i = 1; i < list.length; i++) {
            /** Insert list[i] into a sorted sublist list[0..i-1] so that 
             *  list[0..i] is sorted
             */
            int currentElement = list[i];
            int k;
            
            comp++;
            for (k = i-1; k>= 0 && list[k] > currentElement; k--) {
                list[k+1] = list[k];
                
                comp++;
            }
            move++;
            //insert the current element into list[k + 1]
            list[k + 1] = currentElement;
            
        }
        long finish = System.currentTimeMillis();
        time = finish-start;
        
        System.out.println("Experimental Results:\nInput Size: " + Runner.size + "\nData Type: " + Runner.dType + "\nSort: Insertion\nComparisons: " + comp + "\nMovements: " + move + "\nTime (milli): " + time);
    }
}
