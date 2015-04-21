import java.awt.SystemColor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
	public static void main(String[] args) {

		rl = new RandomList(10000000);
		list = rl.getList();
		pool = Executors.newCachedThreadPool();
		
		qsort(list, 0, list.length-1);
		
		pool.shutdownNow();
		
	}
	
	public static void qsort(int[] array, int left, int right) {
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
		}
		
		pool.execute(new QckSrtThread(array, left, r-1));
		pool.execute(new QckSrtThread(array, r+1, right));
	}
	
	static RandomList rl;
	static int[] list;
	static ExecutorService pool;

}
