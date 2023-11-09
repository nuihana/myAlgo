package BaekJoon.Solve2023.November.Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem6850 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<int[]> pList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pList.add(new int[]{ x, y, 0, 0 });
        }

        pList.sort((a1, a2) -> a1[1] != a2[1] ? a2[1] - a1[1] : a1[0] - a2[0]);
        int[] start = pList.get(0);
        for (int i = 1; i < pList.size(); i++) {
            int[] p = pList.get(i);

            p[2] = p[0] - start[0]; //dx
            p[3] = p[1] - start[1]; //dy
        }

        pList.sort((a1, a2) -> a1[2] * a2[3] != a1[3] * a2[2] ? a1[3] * a2[2] - a1[2] * a2[3] : getDistance(start, a1) - getDistance(start, a2));
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(1);

        int next = 2;
        while (next < n) {
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

        int res = 0;
        List<int[]> ch = new ArrayList<>();
        while (!stack.isEmpty()) ch.add(pList.get(stack.pop()));
        int[] chStart = ch.get(0);
        for (int i = 1; i < ch.size() - 1; i++) {
            int[] p1 = ch.get(i);
            int[] p2 = ch.get(i + 1);

            res += Math.abs((p1[0] - chStart[0]) * (p2[1] - chStart[1]) - (p2[0] - chStart[0]) * (p1[1] - chStart[1]));
        }

        System.out.print(res / 2 / 50);

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
