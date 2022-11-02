package BaekJoon.BasicMath_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2292 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int input = Integer.parseInt(br.readLine());
		
		br.close();
		
		for (int i = 0, boundary = 1; boundary < input || i == 0; i++) {
			boundary = boundary + i * 6;
			
			if (boundary >= input) {
				bw.write(Integer.toString(i + 1));
			}
		}
		bw.flush();
		
		bw.close();
	}
}
