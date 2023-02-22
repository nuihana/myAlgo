package BaekJoon.Solve2022.BasicMath_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Problem9020 {
	private int[] primeNumArr = new int[10000];
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int caseCnt = Integer.parseInt(br.readLine());
		List<Integer> numList = new ArrayList<>();
		
		for (int i = 0; i < caseCnt; i++) {
			numList.add(Integer.parseInt(br.readLine()));
		}

		br.close();
		
		int maxNum = numList.stream().mapToInt(n -> n).max().getAsInt();
		primeNumArr[0] = 1;
		
		for (int i = 1; i <= maxNum; i++) {
			if (primeNumArr[i - 1] == 0) {
				for (int j = 2; j * i <= 10000; j++) {
					primeNumArr[j * i - 1] = 1;
				}
			}
		}
		
		List<Integer> primeNumList = new ArrayList<>();
		for (int i = 0; i < maxNum; i++) {
			if (primeNumArr[i] == 0) {
				primeNumList.add(i + 1);
			}
		}
		
		for (int value : numList) {
			int aVal = 0;
			int bVal = 0;
			for (int i = 0, limit = value / 2; primeNumList.get(i) <= limit; i++) {
				int tmp = value - primeNumList.get(i);
				if (primeNumList.contains(tmp)) {
					aVal = primeNumList.get(i);
					bVal = tmp;
				}
			}
			bw.write(aVal + " " + bVal + "\n");
		}

		bw.close();
	}
}
