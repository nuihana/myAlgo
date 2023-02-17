package BaekJoon;

import java.io.*;
import java.util.*;

public class Problem19538 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int personCnt = Integer.parseInt(br.readLine());
		String[] personRelated = new String[personCnt];

		for (int i = 0; i < personCnt; i++) {
			personRelated[i] = br.readLine();
		}

		int knowPersonCnt = Integer.parseInt(br.readLine());
		int[] initiator = new int[knowPersonCnt];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < knowPersonCnt; i++) {
			initiator[i] = Integer.parseInt(st.nextToken());
		}

		Integer[] result = new Integer[personCnt];
		int[] turn = new int[personCnt];

		Queue<Integer> q = new LinkedList<>();

		for (int tmp : initiator) {
			q.offer(tmp);
			result[tmp - 1] = 0;
		}

		for (int i = 0; i < personCnt; i++) {
			turn[i] = personRelated[i].split(" ").length / 2;
		}

		while(!q.isEmpty()) {
			int tmp = q.poll();

			for (String next : personRelated[tmp - 1].split(" ")) {
				if (next.equals("0")) {
					break;
				}

				int nextInt = Integer.parseInt(next);

				turn[nextInt - 1] -= 1;
				if (result[nextInt - 1] == null && turn[nextInt - 1] <= 0) {
					q.offer(nextInt);
					result[nextInt - 1] = result[tmp - 1] + 1;
				}
			}
		}

		for (int i = 0; i < personCnt; i++) {
			String str = result[i] == null ? "-1" : result[i].toString();
			bw.write(str + " ");
		}

		br.close();
		bw.close();
	}
}
