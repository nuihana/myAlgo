package BaekJoon.Solve2023.March.GraphAndCircuit;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1697 {
    public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		Queue<Point> que = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		visited[from] = true;
		if (from != to) {
			if (from * 2 <= 100000) {
				que.add(new Point(from * 2, 1));
				visited[from * 2] = true;
			}
			if (from < 100000 && !visited[from + 1]) {
				que.add(new Point(from + 1, 1));
				visited[from + 1] = true;
			}
			if (from > 0 && !visited[from - 1]) {
				que.add(new Point(from - 1, 1));
				visited[from - 1] = true;
			}
		} else {
			bw.write("0");
		}

		while(!que.isEmpty()) {
			Point tmp = que.poll();

			if (tmp.idx == to) {
				bw.write(String.valueOf(tmp.ord));
				que.clear();
				break;
			}

			if (tmp.idx * 2 <= 100000 && !visited[tmp.idx * 2]) {
				que.add(new Point(tmp.idx * 2, tmp.ord + 1));
				visited[tmp.idx * 2] = true;
			}
			if (tmp.idx < 100000 && !visited[tmp.idx + 1]) {
				que.add(new Point(tmp.idx + 1, tmp.ord + 1));
				visited[tmp.idx + 1] = true;
			}
			if (tmp.idx > 0 && !visited[tmp.idx - 1]) {
				que.add(new Point(tmp.idx - 1, tmp.ord + 1));
				visited[tmp.idx - 1] = true;
			}
		}

		br.close();
		bw.close();
    }

    class Point {
        int idx;
        int ord;

        public Point(int idx_, int ord_) {
            this.idx = idx_;
            this.ord = ord_;
        }
    }
}
