package BaekJoon.Solve2023.July.ConvexHull;

import java.io.*;
import java.util.*;

public class Problem7420 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int dist = Integer.parseInt(st.nextToken());

        List<int[]> pList = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pList.add(new int[]{x, y, 0, 0});
        }

        pList.sort((a1, a2) -> {
            if (a1[1] != a2[1]) return a1[1] - a2[1];
            return a1[0] - a2[0];
        });

        int[] start = pList.get(0);
        for (int i = 1; i < cnt; i++) {
            int[] now = pList.get(i);

            now[2] = now[0] - start[0];
            now[3] = now[1] - start[1];
        }

        pList.sort((a1, a2) -> {
            if (a1[3] * a2[2] != a1[2] * a2[3]) return a1[3] * a2[2] - a1[2] * a2[3];
            if (a1[1] != a2[1]) return a1[1] - a2[1];
            return a1[0] - a2[0];
        });

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(1);

        int next = 2;
        while(next < cnt) {
            while(stack.size() >= 2) {
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
        while(!stack.isEmpty()) {
            ch.add(pList.get(stack.pop()));
        }

        double res = 0.0;
        for (int i = 0; i < ch.size(); i++) {
            int next_i = (i + 1) % ch.size();

            res += getLen(ch.get(next_i), ch.get(i));
        }
        res += 2 * Math.PI * dist;

        bw.write(String.format("%d", Math.round(res)));

        br.close();
        bw.close();
    }

    private int ccw(int[] a, int[] b, int[] c) {
        return (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]);
    }

    private double getLen(int[] a, int[] b) {
        return Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2));
    }
}
