package BaekJoon.Solve2023.May.MinSpanningTree;

import java.io.*;
import java.util.*;

public class Problem1197 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int pointCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());

        Map<Integer, List<Point>> lineMap = new HashMap<>();
        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (lineMap.get(from) == null) {
                List<Point> tmpList = new ArrayList<>();

                tmpList.add(new Point(to, cost));

                lineMap.put(from, tmpList);
            } else {
                lineMap.get(from).add(new Point(to, cost));
            }

            if (lineMap.get(to) == null) {
                List<Point> tmpList = new ArrayList<>();

                tmpList.add(new Point(from, cost));

                lineMap.put(to, tmpList);
            } else {
                lineMap.get(to).add(new Point(from, cost));
            }
        }

        boolean[] included = new boolean[pointCnt + 1];
        PriorityQueue<Point> que = new PriorityQueue<>((p1, p2) -> p1.cost - p2.cost);
        included[1] = true;
        que.offer(new Point(1, 0));

        int result = 0;

        while(!que.isEmpty()) {
            Point p = que.poll();

            if (!included[p.idx]) {
                included[p.idx] = true;
                result += p.cost;
            }

            if (lineMap.get(p.idx) != null) {
                for (Point to : lineMap.get(p.idx)) {
                    if (!included[to.idx]) {
                        que.add(to);
                    }
                }
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    class Point {
        int idx;
        int cost;
        public Point(int idx_, int cost_) {
            this.idx = idx_;
            this.cost = cost_;
        }
    }
}
