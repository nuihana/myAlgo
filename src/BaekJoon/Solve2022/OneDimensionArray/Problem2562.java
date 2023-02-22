package BaekJoon.Solve2022.OneDimensionArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2562 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int order = 0;
		int max = -1;
		
		for (int i = 0; i < 9; i++) {
			int val = Integer.parseInt(br.readLine());
			
			if (val > max) {
				max = val;
				order = i + 1;
			}
		}
		
		bw.write(max + "\n");
		bw.write(Integer.toString(order));
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}
