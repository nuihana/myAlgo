package BaekJoon.Solve2023.March.String;

import java.io.*;

public class Problem9086 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int inputCnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < inputCnt; i++) {
			String str = br.readLine();

			bw.write(str.charAt(0) + str.charAt(str.length()));
		}
		
		br.close();
		bw.close();
	}
}
