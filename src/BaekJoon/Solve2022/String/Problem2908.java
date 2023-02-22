package BaekJoon.Solve2022.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2908 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		String a = input.nextToken();
		String b = input.nextToken();
		input = null;
		
		boolean flag = true;
		
		for (int i = 0; i < 3; i++) {
			int cprResult = Character.compare(a.charAt(2 - i), b.charAt(2 - i));
			if (cprResult > 0) {
				flag = true;
				i = 3;
			} else if (cprResult < 0) {
				flag = false;
				i = 3;
			}
		}
		
		if (flag) {
			for (int i = 0; i < 3; i++) {
				bw.write(a.substring(2 - i, 3 - i));
			}
		} else {
			for (int i = 0; i < 3; i++) {
				bw.write(b.substring(2 - i, 3 - i));
			}
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}
