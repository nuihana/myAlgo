package BaekJoon.Repeater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11022 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0, input = Integer.parseInt(bf.readLine()); i < input; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append("Case #")
			.append(i+1)
			.append(": " + a + " + " + b + " = ")
			.append(a + b)
			.append("\n");
		}
		
		bf.close();
		
		System.out.print(sb.toString());
	}
}
