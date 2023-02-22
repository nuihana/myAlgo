package BaekJoon.Solve2022.BasicMath_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Problem2581 {
	private int[] primeNumArr = new int[10000];
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int minNum = Integer.parseInt(br.readLine());
		int maxNum = Integer.parseInt(br.readLine());
		
		br.close();

		primeNumArr[0] = 1;
		
		for (int i = 1; i <= maxNum; i++) {
			if (primeNumArr[i - 1] == 0) {
				for (int j = 2; j * i <= 10000; j++) {
					primeNumArr[j * i - 1] = 1;
				}
			}
		}
		
		List<Integer> primeNumList = new ArrayList<>();
		
		for (int i = minNum; i <= maxNum; i++) {
			if (primeNumArr[i - 1] == 0) {
				primeNumList.add(i);
			}
		}
		
		if (primeNumList.isEmpty()) {
			bw.write("-1");
		} else {
			bw.write(Integer.toString(primeNumList.stream().mapToInt(i -> i).sum()) + "\n");
			bw.write(Integer.toString(primeNumList.stream().mapToInt(i -> i).min().getAsInt()));
		}
		
		bw.close();
	}
}
