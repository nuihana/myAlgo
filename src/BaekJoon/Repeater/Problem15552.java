package BaekJoon.Repeater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15552 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0, input = Integer.parseInt(bf.readLine()); i < input; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))
			.append("\n");
		}
		
		bf.close();
		
		System.out.print(sb.toString());
	}
}
