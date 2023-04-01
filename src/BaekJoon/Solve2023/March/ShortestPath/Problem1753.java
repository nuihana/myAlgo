package BaekJoon.Solve2023.March.ShortestPath;

import java.io.*;
import java.util.*;

public class Problem1753 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int pointCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());
        int startPoint = Integer.parseInt(br.readLine());

        Map<Integer, List<Point>> pathMap = new HashMap<>();
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
        }

        int[] resultArr = new int[pointCnt + 1];
        boolean[] visited = new boolean[pointCnt + 1];
        for (int i = 1; i <= pointCnt; i++) {
            resultArr[i] = Integer.MAX_VALUE;
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(startPoint);
        resultArr[startPoint] = 0;
        visited[startPoint] = true;
        while(!que.isEmpty()) {
            int tmp = que.poll();
            int cost = resultArr[tmp];

            if (pathMap.get(tmp) != null) {
                List<Point> path = pathMap.get(tmp);

                for (Point tp : path) {
                    resultArr[tp.value] = Math.min(resultArr[tp.value], cost + tp.worth);
                }
            }

            int nextVal = getMinimumIdx(resultArr, visited);
            if (nextVal != -1) {
                visited[nextVal] = true;
                que.add(nextVal);
            }
        }

        for (int i = 1; i <= pointCnt; i++) {
            String tmp = resultArr[i] == 2147483647 ? "INF" : String.valueOf(resultArr[i]);
            bw.write(tmp);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int getMinimumIdx(int[] arr, boolean[] visited) {
        int tmp = Integer.MAX_VALUE - 1;
        int result = -1;

        for (int i = 1; i < arr.length; i++) {
            if (!visited[i]) {
                tmp = Math.min(tmp, arr[i]);
                if (tmp == arr[i]) {
                    result = i;
                }
            }
        }

        return result;
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
