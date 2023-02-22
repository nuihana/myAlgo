package BaekJoon.Solve2022.Recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem10870 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		
		bw.write(Integer.toString(fibonacci(input)));

		br.close();
		bw.close();
	}
	
	private int fibonacci(int value) {
		if (value == 0) {
			return 0;
		}
		
		if (value == 1) {
			return 1;
		}
		
		int result = 0;
		
		result += fibonacci(value - 2) + fibonacci(value - 1);
		
		return result;
	}
}
