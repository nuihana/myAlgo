package BaekJoon.Solve2022.Repeater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2439 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0, input = Integer.parseInt(bf.readLine()); i < input; i++) {
			for (int j = 0, i_ = input - i - 1; j < i_; j++) {
				sb.append(" ");
			}
			for (int j = 0, i_ = i + 1; j < i_; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		bf.close();
		
		System.out.print(sb.toString());
	}
}
