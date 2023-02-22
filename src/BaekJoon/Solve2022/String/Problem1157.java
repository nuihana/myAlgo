package BaekJoon.Solve2022.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem1157 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		input = input.toLowerCase();
		int[] cntArr = new int[26];
		
		for (int i = 0; i < input.length(); i++) {
			cntArr[input.charAt(i) - 97] += 1;
		}
		
		int duplCnt = 0;
		int cprValue = -1;
		int value = 0; 
		
		for (int i = 0; i < cntArr.length; i++) {
			if (cntArr[i] > cprValue) {
				cprValue = cntArr[i];
				duplCnt = 1;
				value = i + 65;
			} else if (cntArr[i] == cprValue) {
				duplCnt++;
			}
		}
		
		if (duplCnt == 1) {
			bw.write(Character.toString((char) value));
		} else if (duplCnt > 1) {
			bw.write("?");
		}
		bw.flush();
		
		br.close();
		bw.close();
	}
}
