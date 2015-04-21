import java.util.Random;


public class RandomList {
	
	public RandomList(int n) {
		setAmount(n);
		list = new int[amount];
		rand = new Random();
	}
	
	public void setAmount(int n) {
		amount = n;
	}
	
	public int[] getList() {
		for(int i = 0; i < amount; i++) {
			list[i] = rand.nextInt(10000);
		}
		
		return list;
	}
	
	Random rand;
	int[] list;
	int amount;
}
