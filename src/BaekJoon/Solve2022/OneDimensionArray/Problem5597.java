package BaekJoon.Solve2022.OneDimensionArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem5597 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arrs = new int[30];
		
		for (int i = 0; i < 28; i++) {
			arrs[Integer.parseInt(br.readLine()) - 1] = 1;
		}
		
		for (int i = 0, limit = arrs.length; i < limit; i++) {
			if (arrs[i] == 0) {
				bw.write(Integer.toString(i + 1) + "\n");
			}
		}
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}
