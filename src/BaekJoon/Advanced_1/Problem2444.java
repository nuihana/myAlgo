package BaekJoon.Advanced_1;

import java.io.*;

public class Problem2444 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int starSize = Integer.parseInt(br.readLine());

		for (int i = 1, iLimit = starSize * 2; i < iLimit; i++) {
			int tmp = i % starSize;

			if (i < starSize) {
				int space = starSize - tmp;
				int star = tmp * 2 - 1;

				for (int j = 0; j < space; j++) {
					bw.write(" ");
				}

				for (int j = 0; j < star; j++) {
					bw.write("*");
				}
			} else {
				int space = tmp;
				int star = (starSize - tmp) * 2 - 1;

				for (int j = 0; j < space; j++) {
					bw.write(" ");
				}

				for (int j = 0; j < star; j++) {
					bw.write("*");
				}
			}

			bw.write("\n");
		}

		br.close();
		bw.close();
	}
}
