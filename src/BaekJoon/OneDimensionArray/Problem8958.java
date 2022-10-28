package BaekJoon.OneDimensionArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Problem8958 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int valCnt = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < valCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), "X");
			
			int result = 0;
			
			for (; st.hasMoreTokens();) {
				result += getRangeSum(st.nextToken().length());
			}
			
			bw.write(result + "\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
	
	private int getRangeSum(int val) {
		int result = 0;
		
		for (int i = 1; i <= val; i++) {
			result += i;
		}
		
		return result;
	}
}
