package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2750 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int inputCnt = Integer.parseInt(br.readLine());
		
		int[] valueArr = new int[inputCnt];
		
		for (int i = 0; i < inputCnt; i++) {
			valueArr[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();
		
		for (int i = inputCnt - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (valueArr[j] > valueArr[j + 1]) {
					int tmp = valueArr[j + 1];
					valueArr[j + 1] = valueArr[j];
					valueArr[j] = tmp;
				}
			}
		}
		
		for (int val : valueArr) {
			bw.write(val + "\n");
		}
		
		bw.close();
	}
}
