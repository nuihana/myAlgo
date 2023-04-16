package BaekJoon.Solve2023.April.DPAndBT;

import java.io.*;
import java.util.*;

public class Problem11779 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cityCnt = Integer.parseInt(br.readLine());
        int busCnt = Integer.parseInt(br.readLine());

        Map<Integer, List<Point>> pathMap = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < busCnt; i++) {
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
        }
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        PriorityQueue<Point> que = new PriorityQueue<>();
        Integer[][] result = new Integer[cityCnt + 1][2];
        boolean[] visited = new boolean[cityCnt + 1];

        que.offer(new Point(from, 0));
        result[from][0] = 0;
        result[from][1] = 0;
        while(!que.isEmpty()) {
            Point tmp = que.poll();

            if (!visited[tmp.idx]) visited[tmp.idx] = true;
            else continue;

            if (pathMap.get(tmp.idx) != null) {
                for (Point p : pathMap.get(tmp.idx)) {
                    if (result[p.idx][0] == null || result[p.idx][0] > tmp.cost + p.cost) {
                        result[p.idx][0] = tmp.cost + p.cost;
                        result[p.idx][1] = tmp.idx;
                        que.add(new Point(p.idx, tmp.cost + p.cost));
                    }
                }
            }
        }

        bw.write(String.valueOf(result[to][0]));
        bw.newLine();

        Stack<Integer> stack = new Stack<>();
        int idx = to;
        while (idx > 0) {
            stack.add(idx);
            idx = result[idx][1];
        }
        bw.write(String.valueOf(stack.size()));
        bw.newLine();
        while(!stack.empty()) {
            bw.write(stack.pop() + " ");
        }

        br.close();
        bw.close();
    }

    class Point implements Comparable<Point>{
        int idx;
        int cost;
        int ord;

        public Point(int idx_, int cost_) {
            this.idx = idx_;
            this.cost = cost_;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }
}
