package BaekJoon.Solve2023.ShortestPath;

import java.io.*;
import java.util.*;

public class Problem11404 {
    int cityCnt;
    int[][] costMap;
    Map<Integer, List<Line>> pathMap;
    final int inf = 10000000;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        cityCnt = Integer.parseInt(br.readLine());
        int lineCnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        pathMap = new HashMap<>();
        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (pathMap.get(from) == null) {
                List<Line> tmpList = new ArrayList<>();
                tmpList.add(new Line(to, cost));

                pathMap.put(from, tmpList);
            } else {
                pathMap.get(from).add(new Line(to, cost));
            }
        }

        costMap = new int[cityCnt + 1][cityCnt];
        for (int i = 1; i <= cityCnt; i++) {
            dijkstra(i);
        }

        for (int i = 0; i < cityCnt; i++) {
            for (int j = 1; j <=cityCnt; j++) {
                bw.write(costMap[j][i] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private void dijkstra(int start) {
        int[] targetCostMap = new int[cityCnt + 1];
        Arrays.fill(targetCostMap, inf);
        PriorityQueue<Line> que = new PriorityQueue<>((l1, l2) -> l1.cost - l2.cost);
        que.offer(new Line(start, 0));
        targetCostMap[start] = 0;

        while(!que.isEmpty()) {
            Line tmp = que.poll();

            if (targetCostMap[tmp.destination] < tmp.cost) continue;

            if (pathMap.get(tmp.destination) != null) {
                for (Line tl : pathMap.get(tmp.destination)) {
                    if (targetCostMap[tl.destination] > tl.cost + tmp.cost) {
                        targetCostMap[tl.destination] = tl.cost + tmp.cost;
                        que.add(new Line(tl.destination, tl.cost + tmp.cost));
                    }
                }
            }
        }

        for (int i = 1; i <= cityCnt; i++) {
            costMap[i][start - 1] = targetCostMap[i];
        }
    }

    class Line {
        int destination;
        int cost;
        public Line(int destination_, int cost_) {
            this.destination = destination_;
            this.cost = cost_;
        }
    }
}
