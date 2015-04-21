import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class QckSrtThread implements Runnable {
	
	public QckSrtThread(int[] list, int left, int right) {
		this.list = list;
		this.left = left;
		this.right = right;
	}
	
	public void run() {
		
		long start, stop;
		start = System.currentTimeMillis();
		quicksort(list, left, right);
		stop = System.currentTimeMillis();
	
		
		System.out.println("Time it took: " + (stop - start) + " ms");
	}
	
	public static void quicksort(int[] array, int left, int right) {
		int pivot = right;
		int l = left, r = right;
		
		if(left < right) {
			while(l < r) {
				
				while(l < r && array[l] <= array[pivot]) {
					++l;
				}
				
				while(l < r && array[pivot] <= array[r]) {
					--r;
				}
				
				if(l < r) {
					int temp = array[l];
					array[l] = array[r];
					array[r] = temp;
				}
			}
			
			if(r != pivot) {
				int temp = array[pivot];
				array[pivot] = array[r];
				array[r] = temp;
			}
			
			quicksort(list, left, r-1);
			quicksort(list, r+1, right);
		}
	}

	
	private static int[] list;
	private int left;
	private int right;
}
