package BaekJoon.Solve2022.Conditional_Mood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2884 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		bf.close();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		b -= 45;
		
		if (b < 0) {
			b += 60;
			a -= 1;
		}
		
		if (a < 0) {
			a += 24;
		}
		
		System.out.print(a + " " + b);
	}
}
