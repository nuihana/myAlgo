package BaekJoon.Solve2023.October.Geometry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem2254 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int p = Integer.parseInt(br.readLine());
        while (p-- > 0) {
            int n = Integer.parseInt(br.readLine());

            List<int[]> pList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                if (i > 0 && i % 5 == 0) st = new StringTokenizer(br.readLine());
                pList.add(new int[]{ Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0, 0 });
            }

            pList.sort((p1, p2) -> {
                if (p1[1] != p2[1]) return p2[1] - p1[1];
                return p1[0] - p2[0];
            });

            int[] start = pList.get(0);
            for (int i = 1; i < pList.size(); i++) {
                int[] point = pList.get(i);

                point[2] = point[0] - start[0]; // dx
                point[3] = point[1] - start[1]; // dy
            }

            pList.sort((p1, p2) -> {
                if (p1[2] * p2[3] != p1[3] * p2[2]) return p1[3] * p2[2] - p1[2] * p2[3];
                return getDistance(start, p1) - getDistance(start, p2);
            });

            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            stack.push(1);

            int next = 2;
            while(next < n) {
                while (stack.size() >= 2) {
                    int second = stack.pop();
                    int first = stack.peek();

                    if (ccw(pList.get(first), pList.get(second), pList.get(next)) > 0) {
                        stack.push(second);
                        break;
                    }
                }

                stack.push(next++);
            }

            List<int[]> ch = new ArrayList<>();
            while (!stack.isEmpty()) {
                ch.add(pList.get(stack.pop()));
            }
            ch.sort((p1, p2) -> {
                if (p1[2] * p2[3] != p1[3] * p2[2]) return p1[2] * p2[3] - p1[3] * p2[2];
                return getDistance(start, p1) - getDistance(start, p2);
            });

            bw.write(String.valueOf(ch.size()));
            bw.newLine();
            for (int[] chp : ch) {
                bw.write(chp[0] + " " + chp[1]);
                bw.newLine();
            }
            bw.flush();
        }

        bw.close();
        br.close();
    }

    private int getDistance(int[] a, int[] b) {
        return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
    }

    private int ccw(int[] a, int[] b, int[] c) {
        int calc = (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]);
        return Integer.signum(calc);
    }
}
