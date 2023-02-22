package BaekJoon.Solve2022.Conditional_Mood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem14681 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(bf.readLine());
		int b = Integer.parseInt(bf.readLine());
		
		bf.close();
		
		if (a > 0 && b > 0) {
			System.out.print("1");
		} else if (a > 0 && b < 0) {
			System.out.print("4");
		} else if (a < 0 && b < 0) {
			System.out.print("3");
		} else if (a < 0 && b > 0) {
			System.out.print("2");
		}
	}
}
