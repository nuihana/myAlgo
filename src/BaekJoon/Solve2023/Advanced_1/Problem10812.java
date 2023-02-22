package BaekJoon.Solve2023.Advanced_1;

import java.io.*;
import java.util.StringTokenizer;

public class Problem10812 {
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
			int begin = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int mid = Integer.parseInt(st.nextToken()) - 1;

			int[] tmpArr = new int[end - begin + 1];
			for(int j = 0, jLimit = end - begin + 1; j < jLimit; j++) {
				int idx = mid + j > end ? begin + (mid + j) % (end + 1) : mid + j;
				tmpArr[j] = ballArr[idx];
			}

			for (int j = 0; j < tmpArr.length; j++) {
				int idx = begin + j;
				ballArr[idx] = tmpArr[j];
			}
		}

		for (int i = 0; i < containerCnt; i++) {
			bw.write(ballArr[i] + " ");
		}

		br.close();
		bw.close();
	}
}
