package BaekJoon.Solve2022.Geometry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1085 {
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int result = x;
		
		if (y < result) {
			result = y;
		}
		
		if (w - x < result) {
			result = w - x;
		}
		
		if (h - y < result) {
			result = h - y;
		}
		
		bw.write(Integer.toString(result));
		
		br.close();
		bw.close();
	}
}
