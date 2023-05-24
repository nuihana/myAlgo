package BaekJoon.Solve2023.May.Random;

import java.io.*;
import java.util.*;

public class Problem14938 {
    int areaCnt;
    int[] itemCntArr;
    Map<Integer, List<Path>> pathMap;
    final int INF = 1501;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        areaCnt = Integer.parseInt(st.nextToken());
        int searchSize = Integer.parseInt(st.nextToken());
        int pathCnt = Integer.parseInt(st.nextToken());

        itemCntArr = new int[areaCnt + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= areaCnt; i++) {
            itemCntArr[i] = Integer.parseInt(st.nextToken());
        }

        pathMap = new HashMap<>();
        for (int i = 0; i < pathCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (pathMap.get(a) == null) {
                List<Path> tmpList = new ArrayList<>();

                tmpList.add(new Path(b, cost));

                pathMap.put(a, tmpList);
            } else {
                pathMap.get(a).add(new Path(b, cost));
            }

            if (pathMap.get(b) == null) {
                List<Path> tmpList = new ArrayList<>();

                tmpList.add(new Path(a, cost));

                pathMap.put(b, tmpList);
            } else {
                pathMap.get(b).add(new Path(a, cost));
            }
        }

        int result = 0;
        for (int i = 1; i <= areaCnt; i++) {
            result = Math.max(result, daijkstra(i, searchSize));
        }
        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private int daijkstra(int from, int maximumCost) {
        int[] arriveCost = new int[areaCnt + 1];
        Arrays.fill(arriveCost, INF);
        PriorityQueue<Path> que = new PriorityQueue<>((p1, p2) -> p1.cost - p2.cost);

        que.offer(new Path(from, 0));
        arriveCost[from] = 0;

        while(!que.isEmpty()) {
            Path now = que.poll();

            if (pathMap.get(now.idx) != null) {
                for (Path next : pathMap.get(now.idx)) {
                    if (arriveCost[next.idx] > now.cost + next.cost) {
                        arriveCost[next.idx] = now.cost + next.cost;
                        que.offer(new Path(next.idx, now.cost + next.cost));
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= areaCnt; i++) {
            if (arriveCost[i] <= maximumCost) {
                result += itemCntArr[i];
            }
        }

        return result;
    }

    class Path {
        int idx;
        int cost;

        public Path(int idx_, int cost_) {
            this.idx = idx_;
            this.cost = cost_;
        }
    }
}
