package BaekJoon.OneDimensionArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.StringTokenizer;

public class Problem10818 {
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
		
		IntSummaryStatistics stat = Arrays.stream(valArr).summaryStatistics();
		
		bw.write(stat.getMin() + " ");
		bw.write(Integer.toString(stat.getMax()));
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}
