package BaekJoon.Solve2023.July.ConvexHull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem3878 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        while (caseCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int black = Integer.parseInt(st.nextToken());
            int white = Integer.parseInt(st.nextToken());

            List<int[]> blackList = new ArrayList<>();
            for (int i = 0; i < black; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                blackList.add(new int[]{x, y, 0, 0});
            }

            List<int[]> whiteList = new ArrayList<>();
            for (int i = 0; i < white; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                whiteList.add(new int[]{x, y, 0, 0});
            }

            List<int[]> blackCh = getCHPoint(blackList);
            List<int[]> whiteCh = getCHPoint(whiteList);

            boolean res = true;

            if (whiteCh.size() > 2) { // 흰색 점의 집합이 도형을 그릴 수 있을 경우
                for (int[] p : blackCh) { // 모든 검은 점 중
                    if (isInner(whiteCh, p)) { // 흰색 도형 안에 검은 점이 있다면 NO
                        res = false;
                        break;
                    }
                }
            }

            if (res && blackCh.size() > 2) { // 흰색 점에 대해서도 확인
                for (int[] p : whiteCh) {
                    if (isInner(blackCh, p)) {
                        res = false;
                        break;
                    }
                }
            }

            if (res) { // 각 점들이 서로의 도형 안에 포함되지 않았다면, 직선들의 교차를 확인
                for (int i = 0; i < blackCh.size() && res; i++) {
                    for (int j = 0; j < whiteCh.size(); j++) {
                        if (isCross(blackCh.get(i), blackCh.get((i + 1) % blackCh.size()), whiteCh.get(j), whiteCh.get((j + 1) % whiteCh.size()))) {
                            res = false;
                            break;
                        }
                    }
                }
            }

            if (res) bw.write("YES");
            else bw.write("NO");
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private List<int[]> getCHPoint(List<int[]> list) {
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
            if (a1[3] * a2[2] != a1[2] * a2[3]) return a1[3] * a2[2] - a1[2] * a2[3];
            if (a1[1] != a2[1]) return a1[1] - a2[1];
            return a1[0] - a2[0];
        });

        List<int[]> ch = new ArrayList<>();
        if (list.size() >= 2) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            stack.push(1);

            int next = 2;
            while (next < list.size()) {
                while(stack.size() >= 2) {
                    int second = stack.pop();
                    int first = stack.peek();

                    if (ccw(list.get(first), list.get(second), list.get(next)) > 0) {
                        stack.push(second);
                        break;
                    }
                }

                stack.push(next++);
            }

            while(!stack.isEmpty()) {
                ch.add(list.get(stack.pop()));
            }
        } else {
            ch.add(list.get(0));
        }

        return ch;
    }

    private int ccw(int[] a, int[] b, int[] c) {
        return (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]);
    }

    private boolean isInner(List<int[]> list, int[] p) {
        long base = ccw(list.get(0), list.get(1), p);
        for (int i = 1; i < list.size(); i++) {
            if (base * ccw(list.get(i), list.get((i + 1) % list.size()), p) <= 0) return false;
        }
        return true;
    }

    private boolean isCross(int[] a, int[] b, int[] c, int[] d) {
        long abc = ccw(a, b, c), abd = ccw(a, b, d);
        long cda = ccw(c, d, a), cdb = ccw(c, d, b);

        if (abc * abd == 0 && cda * cdb == 0) { // 네 점 중 세점이 일직선에 있다면
            int[] a_ = a;
            int[] b_ = b;
            if (compare(a, b)) {
                a_ = b;
                b_ = a;
            }

            int[] c_ = c;
            int[] d_ = d;
            if (compare(c, d)) {
                c_ = d;
                d_ = c;
            }

            return compareEqual(a_, d_) && compareEqual(c_, b_);
        }

        return abc * abd <= 0 && cda * cdb <= 0;
    }

    private boolean compare(int[] a1, int[] a2) {
        if (a1[1] != a2[1]) return a1[1] > a2[1];
        return a1[0] > a2[0];
    }

    private boolean compareEqual(int[] a1, int[] a2) {
        if (a1[1] != a2[1]) return a1[1] <= a2[1];
        return a1[0] <= a2[0];
    }
}
