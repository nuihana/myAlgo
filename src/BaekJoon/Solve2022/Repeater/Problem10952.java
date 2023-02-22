package BaekJoon.Solve2022.Repeater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10952 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (boolean flag = true; flag; ) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a == 0 && b == 0) {
				flag = false;
			} else {
				sb.append(a + b)
				.append("\n");
			}
		}
		
		bf.close();
		
		System.out.print(sb.toString());
	}
}
