package BaekJoon.Function;

public class Problem4673 {
	public void solution() {
		int[] arr = new int[10000];
		
		for (int i = 0; i < 10000; i++) {
			if (arr[i] == 0) {
				int init = i + 1;
				
				for(int value = init, calcVal = 0; value < 10000; value = calcVal, calcVal = 0) {
					calcVal += value;
					int tmp = value;
					while(tmp > 0) {
						calcVal += tmp % 10;
						tmp /= 10;
					}
					
					if (calcVal <= 10000) {
						arr[calcVal - 1] = 1;
					}
				}
			}
		}
		
		for (int i = 0; i < 10000; i++) {
			if (arr[i] == 0) {
				System.out.println(i + 1);
			}
		}
	}
}
