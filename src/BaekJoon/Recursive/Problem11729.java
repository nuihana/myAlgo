package BaekJoon.Recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem11729 {
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		
		bw.write((int)Math.pow(2, input) - 1 + "\n");
		
		hanoi(1, 2, 3, input);

		bw.close();
		br.close();
	}
	
	private void hanoi(int start, int mid, int end, int val) throws IOException {
		if (val == 1) {
			bw.write(start + " " + end + "\n");
			return;
		}
		
		hanoi(start, end, mid, val - 1);
		
		bw.write(start + " " + end + "\n");
		
		hanoi(mid, start, end, val - 1);
	}
}
