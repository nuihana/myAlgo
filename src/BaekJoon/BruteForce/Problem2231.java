package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2231 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		String output = "0";
		
		for (int i = 1; i < input; i++) {
			int result = 0;
			
			result += i;
			
			result += i % 10;
			
			if (i >= 10) {
				result += i / 10 % 10;
			}
			
			if (i >= 100) {
				result += i / 100 % 10;
			}
			
			if (i >= 1000) {
				result += i / 1000 % 10;
			}
			
			if (i >= 10000) {
				result += i / 10000 % 10;
			}
			
			if (i >= 100000) {
				result += i / 100000 % 10;
			}
			
			if (i >= 1000000) {
				result += i / 1000000 % 10;
			}
			
			if (result == input) {
				output = Integer.toString(i);
			}
		}
		
		bw.write(output);
		
		br.close();
		bw.close();
	}
}
