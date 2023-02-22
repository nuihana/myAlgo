package BaekJoon.Solve2022.BasicMath_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1929 {
	private int[] primeNumArr = new int[1000000];
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int minNum = Integer.parseInt(st.nextToken());
		int maxNum = Integer.parseInt(st.nextToken());
		
		br.close();

		primeNumArr[0] = 1;
		
		for (int i = 1; i <= maxNum; i++) {
			if (primeNumArr[i - 1] == 0) {
				for (int j = 2; j * i <= 1000000; j++) {
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
		
		for (int val : primeNumList) {
			bw.write(Integer.toString(val) + "\n");
		}
		
		bw.close();
	}
}
