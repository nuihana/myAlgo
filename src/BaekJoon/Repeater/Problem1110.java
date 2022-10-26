package BaekJoon.Repeater;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem1110 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		
		br.close();
		
		int result = 0;
		String tmpVal = input;
		for (boolean flag = true; flag; ) {
			if (tmpVal.length() == 1) {
				tmpVal = "0" + tmpVal;
			}
			
			int a = Integer.parseInt(tmpVal.substring(0, 1));
			int b = Integer.parseInt(tmpVal.substring(1, 2));
			
			tmpVal = String.valueOf(b * 10 + (a + b) % 10);
			
			result++;
			if (tmpVal.equals(String.valueOf(input))) {
				flag = false;
			}
		}
		
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
}
