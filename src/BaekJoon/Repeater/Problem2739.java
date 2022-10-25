package BaekJoon.Repeater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2739 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(bf.readLine());
		
		bf.close();
		
		for (int i = 0; i < 10; i++) {
			System.out.print("2 * 1 = " + input * i);
		}
	}
}
