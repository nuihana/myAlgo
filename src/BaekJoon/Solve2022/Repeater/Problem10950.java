package BaekJoon.Solve2022.Repeater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10950 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int caseNum = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < caseNum; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
		}
		
		bf.close();
	}
}
