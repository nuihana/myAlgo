package BaekJoon.Solve2023.ShortestPath;

import java.io.*;
import java.util.*;

public class Problem1504 {
    int pointCnt;
    Map<Integer, List<Point>> pathMap;
    final int inf = 200000000;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        pointCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());

        pathMap = new HashMap<>();
        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int worth = Integer.parseInt(st.nextToken());

            if (pathMap.get(from) == null) {
                List<Point> tmpList = new ArrayList<>();
                tmpList.add(new Point(to, worth));

                pathMap.put(from, tmpList);
            } else {
                pathMap.get(from).add(new Point(to, worth));
            }

            if (pathMap.get(to) == null) {
                List<Point> tmpList = new ArrayList<>();
                tmpList.add(new Point(from, worth));

                pathMap.put(to, tmpList);
            } else {
                pathMap.get(to).add(new Point(from, worth));
            }
        }

        st = new StringTokenizer(br.readLine());
        int midFrom = Integer.parseInt(st.nextToken());
        int midTo = Integer.parseInt(st.nextToken());

        int resultAsc = 0;
        resultAsc += dijkstra(1, midFrom);
        resultAsc += dijkstra(midFrom, midTo);
        resultAsc += dijkstra(midTo, pointCnt);

        int resultDesc = 0;
        resultDesc += dijkstra(1, midTo);
        resultDesc += dijkstra(midTo, midFrom);
        resultDesc += dijkstra(midFrom, pointCnt);

        if (resultAsc >= inf && resultDesc >= inf) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(Math.min(resultDesc, resultAsc)));
        }

        br.close();
        bw.close();
    }

    private int dijkstra(int start, int end) {
        int[] tmpArr = new int[pointCnt + 1];
        for (int i = 1; i <= pointCnt; i++) {
            tmpArr[i] = inf;
        }
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.worth, o2.worth));
        pq.offer(new Point(start, 0));
        tmpArr[start] = 0;
        while (!pq.isEmpty()) {
            Point tmp = pq.poll();

            if (tmpArr[tmp.value] < tmp.worth) continue;

            if (pathMap.get(tmp.value) != null) {
                for (Point tp : pathMap.get(tmp.value)) {
                    if (tmpArr[tp.value] > tmp.worth + tp.worth) {
                        tmpArr[tp.value] = tmp.worth + tp.worth;
                        pq.offer(new Point(tp.value, tmpArr[tp.value]));
                    }
                }
            }
        }
        return tmpArr[end];
    }

    class Point {
        int value;
        int worth;
        public Point(int value_, int worth_) {
            this.value = value_;
            this.worth = worth_;
        }
    }
}
