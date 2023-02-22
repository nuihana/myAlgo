package BaekJoon.Solve2022.OneDimensionArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem10807 {
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
		
		int cprVal = Integer.parseInt(br.readLine());
		
		int result = (int) Arrays.stream(valArr)
						.filter(i -> i == cprVal)
						.count();
		
		bw.write(result);
		bw.flush();
		
		br.close();
		bw.close();
	}
}
