package BaekJoon.Solve2023.March.ShortestPath;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem13549 {
    Integer[] field;
    final int limit = 100000;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        field = new Integer[limit + 1];

        bw.write(String.valueOf(dijkstra(start, end)));

        br.close();
        bw.close();
    }

    private int dijkstra(int start, int end) {
        PriorityQueue<Point> que = new PriorityQueue<>((p1, p2) -> p1.time - p2.time == 0 ? p1.idx - p2.idx : p1.time - p2.time);
        que.offer(new Point(start, 0));
        field[start] = 0;
        while (!que.isEmpty()) {
            Point tmp = que.poll();

            if (tmp.idx * 2 <= limit && field[tmp.idx * 2] == null) {
                field[tmp.idx * 2] = tmp.time;
                que.offer(new Point(tmp.idx * 2, tmp.time));
            }

            if (tmp.idx > 0 && field[tmp.idx - 1] == null) {
                field[tmp.idx - 1] = tmp.time + 1;
                que.offer(new Point(tmp.idx - 1, tmp.time + 1));
            }

            if (tmp.idx < limit && field[tmp.idx + 1] == null) {
                field[tmp.idx + 1] = tmp.time + 1;
                que.offer(new Point(tmp.idx + 1, tmp.time + 1));
            }

            if (field[end] != null) {
                que.clear();
            }
        }

        return field[end];
    }

    class Point {
        int idx;
        int time;
        public Point(int idx_, int time_) {
            this.idx = idx_;
            this.time = time_;
        }
    }
}
