
public class SelectionSort {
    /** The method for sorting the numbers */
    static int comp;
        static int move;
        static long time;
    public static void selectionSort(int[] list) { //int[] list?
            long start = System.currentTimeMillis();
        for (int i = 0; i < list.length -1; i++) {
            // Find the minimum in the list[i..list.length-1]
            int currentMin = list[i];
            int currentMinIndex = i;
            
            for (int j = i+1; j < list.length; j++) {
                comp++;
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                    
                }
            }
            
            //  Swap list[i] wiht list[currentMinIndex[ if necessary
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
                move++;
            }
            comp++;
        }
        long finish = System.currentTimeMillis();
                time = finish-start;
        
               System.out.println("Experimental Results:\nInput Size: " + Runner.size + "\nData Type: " + Runner.dType + "\nSort: Selection\nComparisons: " + comp + "\nMovements: " + move + "\nTime (milli): " + time);
    }
}
