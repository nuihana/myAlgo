package BaekJoon.Solve2023.Advanced_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem4344 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int caseCnt = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < caseCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int stuCnt = Integer.parseInt(st.nextToken());
			int[] scoreArr = new int[stuCnt];
			
			double average = 0;
			
			for (int j = 0; st.hasMoreTokens(); j++) {
				scoreArr[j] = Integer.parseInt(st.nextToken());
				average += scoreArr[j];
			}
			
			average = average / stuCnt;
			
			final double innerAverage = average;
			
			int overAverageCnt =  (int) Arrays.stream(scoreArr)
											.filter(n -> n > innerAverage)
											.count();
			
			bw.write(setPercentageFormat((Double.valueOf(overAverageCnt) / stuCnt) * 100) + "%\n");
		}
		
		br.close();
		bw.close();
	}
	
	private String setPercentageFormat(Double a) {
		String result;
		
		double value = Math.round(a * 1000) / 1000.0;
		
		if (value > 10) {
			result = String.format("%-6s", Double.toString(value)).replaceAll(" ", "0");
		} else {
			result = String.format("%-5s", Double.toString(value)).replaceAll(" ", "0");
		}
		
		return result;
	}
}
