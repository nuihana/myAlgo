package BaekJoon.Solve2023.ShortestPath;

import java.io.*;
import java.util.*;

public class Problem9370 {
    final int maxCost = 20000000;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int pointCnt = Integer.parseInt(st.nextToken());
            int lineCnt = Integer.parseInt(st.nextToken());
            int purposeCnt = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            Map<Integer, List<Point>> pathMap = new HashMap<>();

            for (int j = 0; j < lineCnt; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                if (pathMap.get(from) == null) {
                    List<Point> tmpList = new ArrayList<>();
                    tmpList.add(new Point(to, cost));

                    pathMap.put(from, tmpList);
                } else {
                    pathMap.get(from).add(new Point(to, cost));
                }

                if (pathMap.get(to) == null) {
                    List<Point> tmpList = new ArrayList<>();
                    tmpList.add(new Point(from, cost));

                    pathMap.put(to, tmpList);
                } else {
                    pathMap.get(to).add(new Point(from, cost));
                }
            }

            List<Integer> results = new ArrayList<>();
            for (int j = 0; j < purposeCnt; j++) {
                int purposeIdx = Integer.parseInt(br.readLine());

                int shortestPath = dijkstar(start, purposeIdx, pointCnt, pathMap);

                int ascPath = 0;
                ascPath += dijkstar(start, p1, pointCnt, pathMap);
                for (Point tp : pathMap.get(p1)) {
                    if (tp.idx == p2) {
                        ascPath += tp.cost;
                    }
                }
                ascPath += dijkstar(p2, purposeIdx, pointCnt, pathMap);

                int descPath = 0;
                descPath += dijkstar(start, p2, pointCnt, pathMap);
                for (Point tp : pathMap.get(p2)) {
                    if (tp.idx == p1) {
                        descPath += tp.cost;
                    }
                }
                descPath += dijkstar(p1, purposeIdx, pointCnt, pathMap);

                if (shortestPath == Math.min(ascPath, descPath)) {
                    results.add(purposeIdx);
                }
            }

            Collections.sort(results);
            for (int result : results) {
                bw.write(result + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int dijkstar(int from, int to, int size, Map<Integer, List<Point>> map) {
        int[] costArr = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            costArr[i] = maxCost;
        }
        PriorityQueue<Point> que = new PriorityQueue<>((p1, p2) -> p1.cost - p2.cost);
        que.offer(new Point(from, 0));
        costArr[from] = 0;
        while (!que.isEmpty()) {
            Point tmp = que.poll();

            if (costArr[tmp.idx] < tmp.cost) continue;

            if (map.get(tmp.idx) != null) {
                for (Point tp : map.get(tmp.idx)) {
                    if (costArr[tp.idx] > tmp.cost + tp.cost) {
                        costArr[tp.idx] = tmp.cost + tp.cost;
                        que.offer(new Point(tp.idx, costArr[tp.idx]));
                    }
                }
            }
        }
        return costArr[to];
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
