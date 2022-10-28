package BaekJoon.OneDimensionArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem1546 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int valCnt = Integer.parseInt(br.readLine());
		int[] valArr = new int[valCnt];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; st.hasMoreTokens(); i++) {
			valArr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = null;
		
		int max = Arrays.stream(valArr)
					.max().getAsInt();
		
		double convertedTotal = 0;
		
		for (int val : valArr) {
			convertedTotal += Double.valueOf(val) / max * 100;
		}
		
		bw.write(Double.toString(convertedTotal / valCnt));
		bw.flush();
		
		br.close();
		bw.close();
	}
}
