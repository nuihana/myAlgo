package BaekJoon.recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem25501 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < input; i++) {
			bw.write(isPalindrome(br.readLine()) + "\n");
		}

		br.close();
		bw.close();
	}
	
	private String isPalindrome(String val) {
		return recursion(val, 0, val.length(), 0);
	}
	
	private String recursion(String val, int start, int end, int cnt) {
		cnt++;
		
		if (start >= end) {
			return "1 " + cnt;
		} else if (val.charAt(start) != val.charAt(end)) {
			return "0 " + cnt;
		} else {
			return recursion(val, start + 1, end - 1, cnt);
		}
	}
}
