package BaekJoon.Solve2022.Recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem10872 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		
		bw.write(Integer.toString(factorial(input)));

		br.close();
		bw.close();
	}
	
	private int factorial(int value) {
		if (value <= 1) {
			return 1;
		}
		
		int result = 1;
		
		result *= value;
		result *= factorial(value - 1);
		
		return result;
	}
}
