package BaekJoon.Solve2022.Conditional_Mood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2525 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int c = Integer.parseInt(bf.readLine());
		
		bf.close();
		
		b += c;
		
		if (b >= 60) {
			int div = b / 60;
			b = b % 60;
			a += div;
		}
		
		if (a >= 24) {
			a = a % 24;
		}
		
		System.out.print(a + " " + b);
	}
}
