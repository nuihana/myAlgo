package BaekJoon.BasicMath_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1193 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int input = Integer.parseInt(br.readLine());
		
		br.close();
		
		int lineIdx = 0;
		int colIdx = 0;
		
		for (int i = 1, boundary = 0; boundary < input; i++) {
			boundary += i;
			
			if (boundary >= input) {
				lineIdx = i;
				colIdx = boundary - input;
			}
		}
		
		if (lineIdx % 2 == 0) {
			bw.write((lineIdx - colIdx) + "/" + (colIdx + 1));
		} else {
			bw.write((colIdx + 1) + "/" + (lineIdx - colIdx));
		}
		bw.flush();
		
		bw.close();
	}
}
