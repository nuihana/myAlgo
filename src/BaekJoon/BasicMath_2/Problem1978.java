package BaekJoon.BasicMath_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1978 {
	private int[] primeNumArr = new int[1000];
	private int limit = 1;
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int numCnt = Integer.parseInt(br.readLine());
		int result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		primeNumArr[0] = 1;
		
		br.close();
		
		for (int i = 0; i < numCnt; i++) {
			int value = Integer.parseInt(st.nextToken());
			
			if (isPrime(value)) {
				result++;
			}
		}
		
		bw.write(Integer.toString(result));
		
		bw.close();
	}
	
	private boolean isPrime(int num) {
		boolean result = false;
		
		if (num > limit) {
			for (int i = limit + 1; i <= num; i++) {
				if (primeNumArr[i - 1] == 0) {
					for (int j = 2; j * i <= 1000; j++) {
						primeNumArr[j * i - 1] = 1;
					}
				}
			}
			
			if (primeNumArr[num - 1] == 0) {
				result = true;
			}
			limit = num;
		} else {
			if (primeNumArr[num - 1] == 0) {
				result = true;
			}
		}
		
		return result;
	}
}
