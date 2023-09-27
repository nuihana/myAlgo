package BaekJoon.Solve2023.September.Geometry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem9240 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new int[]{x, y, 0, 0}); // x, y, dx, dy
        }

        // convex hull
        list.sort((a1, a2) -> {
            if (a1[1] != a2[1]) return a1[1] - a2[1];
            return a1[0] - a2[0];
        });
        int[] start = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int[] now = list.get(i);

            now[2] = now[0] - start[0];
            now[3] = now[1] - start[1];
        }
        list.sort((a1, a2) -> {
            if (a1[2] * a2[3] != a1[3] * a2[2]) return a1[3] * a2[2] - a1[2] * a2[3]; // 시계 방향 정렬(ccw)
            return getPowD(start, a1) - getPowD(start, a2); //직선거리가 더 가까운 순서
        });

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(1);

        int next = 2;
        while(next < c) {
            while (stack.size() >= 2) {
                int second = stack.pop();
                int first = stack.peek();

                if (ccw(list.get(first), list.get(second), list.get(next)) > 0) {
                    stack.push(second);
                    break;
                }
            }

            stack.push(next++);
        }

        List<int[]> chList = new ArrayList<>(); // 컨벡스 헐 list
        while(!stack.isEmpty()) {
            chList.add(list.get(stack.pop()));
        }

        // rotating calipers
        int p1 = 0, p2 = 1;
        double max = getDistance(chList.get(p1), chList.get(p2));
        for (int i = 0; i < chList.size() * 2; i++) {
            int np1 = (p1 + 1) % chList.size();
            int np2 = (p2 + 1) % chList.size();

            int[] vec_p1 = { chList.get(p1)[0] - chList.get(np1)[0], chList.get(p1)[1] - chList.get(np1)[1] };
            int[] vec_p2 = { chList.get(p2)[0] - chList.get(np2)[0], chList.get(p2)[1] - chList.get(np2)[1] };

            double tmp = ccw(vec_p1, vec_p2);

            if (tmp > 0) p1 = np1;
            if (tmp < 0) p2 = np2;
            if (tmp == 0) {
                p1 = np1;
                p2 = np2;
            }

            double dist = getDistance(chList.get(p1), chList.get(p2));
            max = Math.max(max, dist);
        }

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }

    private double getDistance(int[] p1, int[] p2) {
        return Math.sqrt(Math.pow(p2[0] - p1[0], 2) + Math.pow(p2[1] - p1[1], 2));
    }

    private int getPowD(int[] p1, int[] p2) {
        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }

    private int ccw(int[] a, int[] b, int[] c) { // point
        return (b[0] - a[0]) * (c[1] - a[1]) - (c[0] - a[0]) * (b[1] - a[1]);
    }

    private int ccw(int[] a, int[] b) { // vector
        return a[0] * b[1] - b[0] * a[1];
    }
}
