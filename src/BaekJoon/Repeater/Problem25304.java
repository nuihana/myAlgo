package BaekJoon.Repeater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem25304 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int result = Integer.parseInt(bf.readLine());
		int calcResult = 0;
		
		for (int i = 0, buyNum = Integer.parseInt(bf.readLine()); i < buyNum; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			calcResult += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		}
		
		bf.close();
		
		if (result == calcResult) {
			System.out.print("Yes");
		} else {
			System.out.print("No");
		}
	}
}
