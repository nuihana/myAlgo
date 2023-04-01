package BaekJoon.Solve2023.March.OneDimensionArray;

import java.io.*;
import java.util.*;

public class Problem10811 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int containerCnt = Integer.parseInt(st.nextToken());
		int inputCnt = Integer.parseInt(st.nextToken());
		int[] ballArr = new int[containerCnt];

		for (int i = 0; i < containerCnt; i++) {
			ballArr[i] = i + 1;
		}

		for (int i = 0; i < inputCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;

			while (from < to) {
				int tmp = ballArr[from];
				ballArr[from] = ballArr[to];
				ballArr[to] = tmp;

				from++;
				to--;
			}
		}

		for (int i = 0; i < containerCnt; i++) {
			bw.write(ballArr[i] + " ");
		}

		br.close();
		bw.close();
	}
}
