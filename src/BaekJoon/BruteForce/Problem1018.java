package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1018 {
	String[] answerRows = {"BWBWBWBW", "WBWBWBWB"};
	String[] input;
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int line = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		input = new String[line];
		
		int result = Integer.MAX_VALUE;
		
		for (int i = 0; i < line; i++) {
			input[i] = br.readLine();
		}
		
		for (int i = 0, limit_line = line - 8; i < limit_line; i++) {
			for (int j = 0, limit_col = col - 8; j < limit_col; j++) {
				int tmp = getNeedChange(i, j);
				
				if (tmp < result) {
					result = tmp;
				}
			}
		}
		
		bw.write(Integer.toString(result));
		
		br.close();
		bw.close();
	}
	
	private int getNeedChange(int x, int y) {
		int result_b = 0;
		int result_w = 0;
		
		for (int i = x, limit_i = x + 8; i < limit_i; i++) {
			String cpr = input[i].substring(y, y + 8);
			String answer_b = answerRows[i % 2];
			String answer_w = answerRows[(i + 1) % 2];
			
			for (int j = 0; j < 8; j++) {
				if (!cpr.substring(j, j+1).equals(answer_b.substring(j, j+1))) {
					result_b++;
				}
				if (!cpr.substring(j, j+1).equals(answer_w.substring(j, j+1))) {
					result_w++;
				}
			}
		}
		
		return result_b > result_w ? result_w : result_b;
	}
}