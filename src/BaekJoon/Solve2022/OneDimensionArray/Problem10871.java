package BaekJoon.Solve2022.OneDimensionArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem10871 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int valCnt = Integer.parseInt(st.nextToken());
		int cprVal = Integer.parseInt(st.nextToken());
		
		int[] valArr = new int[valCnt];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; st.hasMoreTokens(); i++) {
			valArr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = null;
		
		Arrays.stream(valArr)
			.filter(i -> i < cprVal)
			.forEach(i -> {
				try {
					bw.write(Integer.toString(i));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}
