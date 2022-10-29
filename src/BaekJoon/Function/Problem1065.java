package BaekJoon.Function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1065 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		
		br.close();
		
		int result = 0;
		
		for (int i = 1; i <= input; i++) {
			if (i < 100) {
				result++;
			} else {
				boolean flag = true;
				for (int j = 0, tmp = i, value = 0, diff = 0; tmp > 0; j++) {
					int thisNum = tmp % 10;
					if (j == 1) {
						diff = thisNum - value;
					}
					if (j > 1) {
						if (thisNum - value != diff) {
							flag = false;
							tmp = -1;
						}
					}
					value = tmp % 10;
					tmp /= 10;
				}
				
				if (flag) {
					result++;
				}
			}
		}
		
		System.out.print(result);
	}
}
