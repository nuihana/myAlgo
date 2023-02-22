package BaekJoon.Solve2022.IO_ArithmeticOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10998 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		bf.close();
		
		System.out.print(Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
	}
}
