package BaekJoon.Solve2022.Repeater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem8393 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(bf.readLine());
		
		bf.close();
		
		int result = 0;
		
		for (int i = 1; i <= input; i++) {
			result += i;
		}

		System.out.print(result);
	}
}
