package BaekJoon.Solve2023.May.Random;

import java.io.*;
import java.util.*;

public class Problem15686 {
    int leastStoreCnt;
    int[] storeArr;
    int[][] distance;
    int minResult = Integer.MAX_VALUE;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int citySize = Integer.parseInt(st.nextToken());
        leastStoreCnt = Integer.parseInt(st.nextToken());

        List<Point> homeList = new ArrayList<>();
        List<Point> storeList = new ArrayList<>();
        for (int i = 0; i < citySize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < citySize; j++) {
                int info = Integer.parseInt(st.nextToken());

                if (info == 1) {
                    homeList.add(new Point(i, j));
                } else if (info == 2) {
                    storeList.add(new Point(i, j));
                }
            }
        }
        distance = new int[homeList.size()][storeList.size()];
        for (int i = 0; i < homeList.size(); i++) {
            Point tmpHome = homeList.get(i);
            for (int j = 0; j < storeList.size(); j++) {
                distance[i][j] = tmpHome.getDistance(storeList.get(j));
            }
        }

        storeArr = new int[leastStoreCnt];
        getCase(0, 0);
        bw.write(String.valueOf(minResult));

        br.close();
        bw.close();
    }

    private void getCase(int idx, int start) {
        if (idx == leastStoreCnt) {
            getMinimum();
            return;
        }

        for (int i = start; i < distance[0].length; i++) {
            storeArr[idx] = i;
            getCase(idx + 1, i + 1);
        }
    }
    private void getMinimum() {
        int[] minHomeToStore = new int[distance.length];
        Arrays.fill(minHomeToStore, Integer.MAX_VALUE);
        for (int i = 0; i < leastStoreCnt; i++) {
            for (int j = 0; j < distance.length; j++) {
                minHomeToStore[j] = Math.min(minHomeToStore[j], distance[j][storeArr[i]]);
            }
        }
        int result = 0;
        for (int val : minHomeToStore) {
            result += val;
        }
        minResult = Math.min(minResult, result);
    }

    class Point {
        int x;
        int y;

        public Point(int x_, int y_) {
            this.x = x_;
            this.y = y_;
        }

        public int getDistance(Point to) {
            return Math.abs(to.y - this.y) + Math.abs(to.x - this.x);
        }
    }
}
