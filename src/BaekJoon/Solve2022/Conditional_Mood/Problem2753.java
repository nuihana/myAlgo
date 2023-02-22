package BaekJoon.Solve2022.Conditional_Mood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2753 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(bf.readLine());
		
		bf.close();
		
		if (input % 4 == 0 && (input % 100 != 0 || input % 400 == 0)) {
			System.out.print("1");
		} else {
			System.out.print("0");
		}
	}
}
