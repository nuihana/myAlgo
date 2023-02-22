package BaekJoon.Solve2022.IO_ArithmeticOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1008 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		bf.close();
		
		System.out.print(Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken()));
	}
}
