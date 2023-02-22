package BaekJoon.Solve2022.BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem1436 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		int featCnt = 0;
		boolean flag = true;
		
		for (int i = 666; flag; i++) {
			String tmp = String.valueOf(i);
			
			if (tmp.contains("666")) {
				featCnt++;
				
				if (featCnt == input) {
					flag = false;
					bw.write(Integer.toString(i));
				}
			}
		}
		
		br.close();
		bw.close();
	}
}