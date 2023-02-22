package BaekJoon.Solve2023.String;

import java.io.*;

public class Problem11718 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "";
		while((str = br.readLine()) != null) {
			bw.write(str + "\n");
		}

		br.close();
		bw.close();
	}
}
