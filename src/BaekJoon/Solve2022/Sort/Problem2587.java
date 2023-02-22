package BaekJoon.Solve2022.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2587 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] valueArr = new int[5];
		
		for (int i = 0; i < 5; i++) {
			valueArr[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();
		
		for (int i = 4; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (valueArr[j] > valueArr[j + 1]) {
					int tmp = valueArr[j + 1];
					valueArr[j + 1] = valueArr[j];
					valueArr[j] = tmp;
				}
			}
		}
		
		int summary = 0;
		for (int val : valueArr) {
			summary += val;
		}
		
		bw.write(summary / 5 + "\n");
		bw.write(Integer.toString(valueArr[2]));
		bw.close();
	}
}
