import java.util.concurrent.Executors;


public class QuickSort {
	public static void main(String[] args) {

		RandomList rl = new RandomList(10000);
		int[] list = rl.getList();
		quicksort(list);
		
		for(int i : list) {
			System.out.println(i);
		}
	}
	
	public static void quicksort(int[] array) {
		qsort(array, 0, array.length-1);
	}
	
	private static void qsort(int[] array, int left, int right) {
		int pivot = right;
		int l = left, r = right;
		
		if(left < right) {
			while(l < r) {
				
				while(l < r && array[l] <= array[pivot]) {
					l++;
				}
				
				while(l < r && array[pivot] <= array[right]) {
					r--;
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
			
			qsort(array, left, r-1);
			qsort(array, r+1, right);
		}
	}
	
	private static void quicksort(int[] array, int left, int right) {
		int pivot = right;

        int l = left, r = right;

        if (left < right) {
            while (l < r) {

                while (l < r && array[l] <= array[pivot]) {
                    ++l;
                }

                while (l < r && array[pivot] <= array[r]) {
                    --r;
                }

                if (l < r) {
                    int temp = array[l];
                    array[l] = array[r];
                    array[r] = temp;
                }
            }

            if (r != pivot) {
                int temp = array[pivot];
                array[pivot] = array[r];
                array[r] = temp;
            }

            quicksort(array, left, r - 1);
            quicksort(array, r + 1, right);
        }
	}
}
