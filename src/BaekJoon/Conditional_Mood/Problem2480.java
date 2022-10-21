package BaekJoon.Conditional_Mood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2480 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		bf.close();
		
		int result = 0;
		if (a == b && b == c) {
			result = 10000 + a * 1000;
		} else if (a == b || b == c || a == c) {
			if (a == b) {
				result = 1000 + a * 100;
			} else {
				result = 1000 + c * 100;
			}
		} else {
			if (a > b) {
				if (a > c) {
					result = a * 100;
				} else {
					result = c * 100;
				}
			} else {
				if (b > c) {
					result = b * 100;
				} else {
					result = c * 100;
				}
			}
		}
		
		System.out.print(result);
	}
}
