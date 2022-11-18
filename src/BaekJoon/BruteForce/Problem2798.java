package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2798 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int inputCnt = Integer.parseInt(st.nextToken());
		int purposeNum = Integer.parseInt(st.nextToken());
		int[] numArr = new int[inputCnt];
		int rstNum = 0;
		int turm = purposeNum;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < inputCnt; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numArr);
		
		for (int i = 0, result = 0; i < inputCnt; i++) {
			result = numArr[i];
			for (int j = i + 1, result_J = result; j < inputCnt; j++) {
				int result_JJ = result_J + numArr[j];
				for (int k = j + 1, result_k = result_JJ; k < inputCnt; k++) {
					int result_kk = result_k + numArr[k];
					if (result_kk <= purposeNum && turm > purposeNum - result_kk) {
						rstNum = result_kk;
						turm = purposeNum - result_kk;
					}
				}
			}
		}
		
		bw.write(Integer.toString(rstNum));
		
		br.close();
		bw.close();
	}
}
