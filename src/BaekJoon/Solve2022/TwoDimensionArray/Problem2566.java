package BaekJoon.Solve2022.TwoDimensionArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2566 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] result = new int[3];
		
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int val = Integer.parseInt(st.nextToken());
				if (val > result[0]) {
					result[0] = val;
					result[1] = i;
					result[2] = j;
				}
			}
		}
		
		bw.write(result[0] + "\n");
		bw.write(result[1] + " " + result[2]);
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}
