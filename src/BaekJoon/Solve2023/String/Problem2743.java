package BaekJoon.Solve2023.String;

import java.io.*;

public class Problem2743 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();

		bw.write(Integer.toString(str.length()));
		
		br.close();
		bw.close();
	}
}
