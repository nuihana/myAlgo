package BaekJoon.Solve2023.September.Geometry;

import java.io.*;
import java.util.*;

public class Problem2261 {
    List<int[]> pList;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        pList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pList.add(new int[]{x, y});
        }

        pList.sort((a1, a2) -> a1[0] - a2[0]); // x좌표 오름차순
        bw.write(String.valueOf(getMinimumDistance(0, n - 1)));

        br.close();
        bw.close();
    }

    private int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    private int bruteForce(int start, int end) {
        int res = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                res = Math.min(res, distance(pList.get(i), pList.get(j)));
            }
        }

        return res;
    }

    private int getMinimumDistance(int start, int end) {
        //구간내 점이 3개 이하일 경우 분할하면 1개의 점만 남아 거리를 구할 수 없으므로, 3개일 때 bf
        if (end - start < 3) {
            return bruteForce(start, end);
        }

        //좌우 분할
        int mid = (start + end) / 2;

        int lMin = getMinimumDistance(start, mid);
        int rMin = getMinimumDistance(mid + 1, end);

        int minDist = Math.min(lMin, rMin);

        //중심에 걸치는 영역 좌우분할의 최소값보다 작은 영역에서 확인
        int band = middleRange(start, mid, end, minDist);

        return Math.min(band, minDist);
    }

    private int middleRange(int start, int mid, int end, int minDist) {
        List<int[]> list = new ArrayList<>();

        int xDist;
        int midX = pList.get(mid)[0];
        for (int i = start; i <= end; i++) {
            xDist = pList.get(i)[0] - midX;

            if (xDist * xDist < minDist) list.add(pList.get(i));
        }

        list.sort(yComp);

        int yDist;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                yDist = list.get(i)[1] - list.get(j)[1];
                if (yDist * yDist < minDist) {
                    minDist = Math.min(distance(list.get(i), list.get(j)), minDist);
                } else {
                    break;
                }
            }
        }

        return minDist;
    }

    Comparator<int[]> yComp = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    };
}
