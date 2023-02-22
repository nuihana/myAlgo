package BaekJoon.Solve2022.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem25305 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int stuCnt = Integer.parseInt(st.nextToken());
		int cutline = Integer.parseInt(st.nextToken());
		int[] valueArr = new int[stuCnt];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; st.hasMoreTokens(); i++) {
			valueArr[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		for (int i = stuCnt - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (valueArr[j] < valueArr[j + 1]) {
					int tmp = valueArr[j + 1];
					valueArr[j + 1] = valueArr[j];
					valueArr[j] = tmp;
				}
			}
		}
		
		bw.write(Integer.toString(valueArr[cutline - 1]));
		bw.close();
	}
}
