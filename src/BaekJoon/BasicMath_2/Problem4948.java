package BaekJoon.BasicMath_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Problem4948 {
	private int[] primeNumArr = new int[246912];
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		List<Integer> numList = new ArrayList<>();

		for (boolean flag = true; flag; ) {
			int value = Integer.parseInt(br.readLine());
			
			if (value == 0) {
				flag = false;
			} else {
				numList.add(value);
			}
		}
		
		br.close();

		int maxNum = numList.stream().mapToInt(i -> i).max().getAsInt();
		primeNumArr[0] = 1;
		
		for (int i = 1; i <= maxNum; i++) {
			if (primeNumArr[i - 1] == 0) {
				for (int j = 2; j * i <= 246912; j++) {
					primeNumArr[j * i - 1] = 1;
				}
			}
		}
		
		for (int val : numList) {
			int result = 0;

			for (int i = val, limit = val * 2; i <= limit; i++) {
				if (primeNumArr[i - 1] == 0) {
					result++;
				}
			}
			
			bw.write(Integer.toString(result) + "\n");
		}
		
		bw.close();
	}
}
