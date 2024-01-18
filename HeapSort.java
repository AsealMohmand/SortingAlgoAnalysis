
public class HeapSort {
	/** Heap sort method */
	static int comp;
        static int move;
        static long time;
	public static <E extends Comparable<E>> void heapSort(E[] list) {
	    long start = System.currentTimeMillis();
		//	Create a Heap of integers
		Heap<E> heap = new Heap<>();
		
		//	Add elements to the heap
		for (int i = 0; i < list.length; i++)
			heap.add(list[i]);
		
		//	Remove elements from the heap
		for (int i = list.length -1; i >= 0; i--)
			list[i] = heap.remove();
	    long finish = System.currentTimeMillis();
                time = finish-start;
        
               System.out.println("Experimental Results:\nInput Size: " + Runner.size + "\nData Type: " + Runner.dType + "\nSort: Heap\nComparisons: " + comp + "\nMovements: " + move + "\nTime (milli): " + time);
	}
	
	
 	/**	A test method */
	public static void main(String[] args) {
		Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
		heapSort(list);
		for(int i = 0; i < list.length; i++)
			System.out.println(list[i] + " ");
	}
	
}
