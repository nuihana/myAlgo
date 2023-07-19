package BaekJoon.Solve2023.July.ConvexHull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem10254 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            int pointCnt = Integer.parseInt(br.readLine());

            List<long[]> pointList = new ArrayList<>();
            for (int i = 0; i < pointCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());
                pointList.add(new long[]{x, y, 0, 0});
            }

            pointList.sort((a1, a2) -> {
                if (a1[1] != a2[1]) return Long.compare(a1[1], a2[1]);
                return Long.compare(a1[0], a2[0]);
            });
            long[] start = pointList.get(0);
            for (int i = 1; i < pointList.size(); i++) {
                long[] now = pointList.get(i);

                now[2] = now[0] - start[0];
                now[3] = now[1] - start[1];
            }

            pointList.sort((a1, a2) -> {
                if (a1[3] * a2[2] != a1[2] * a2[3]) return Long.compare(a1[3] * a2[2], a1[2] * a2[3]);
                if (a1[1] != a2[1]) return Long.compare(a1[1], a2[1]);
                return Long.compare(a1[0], a2[0]);
            });

            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            stack.push(1);

            int next = 2;
            while (next < pointCnt) {
                while(stack.size() >= 2) {
                    int second = stack.pop();
                    int first = stack.peek();

                    if (ccw(pointList.get(first), pointList.get(second), pointList.get(next)) > 0) {
                        stack.push(second);
                        break;
                    }
                }

                stack.push(next++);
            }

            List<long[]> ch = new ArrayList<>();
            while(!stack.isEmpty()) {
                ch.add(pointList.get(stack.pop()));
            }

            long max = 0;
            long[] ans1 = null, ans2 = null;
            int j = 1;

            for (int i = 0; i < ch.size(); i++) {
                int i_next = (i + 1) % ch.size();
                while (true) {
                    int j_next = (j + 1) % ch.size();

                    long[] iVec = new long[2];
                    long[] jVec = new long[2];

                    iVec[0] = ch.get(i_next)[0] - ch.get(i)[0];
                    iVec[1] = ch.get(i_next)[1] - ch.get(i)[1];

                    jVec[0] = ch.get(j_next)[0] - ch.get(j)[0];
                    jVec[1] = ch.get(j_next)[1] - ch.get(j)[1];

                    long[] tmp = new long[]{0, 0};

                    if (ccw(tmp, iVec, jVec) < 0) j = j_next;
                    else break;
                }

                long dist = dist(ch.get(i), ch.get(j));

                if (dist > max) {
                    max = dist;
                    ans1 = ch.get(i);
                    ans2 = ch.get(j);
                }
            }

            bw.write(ans1[0] + " " + ans1[1] + " " + ans2[0] + " " + ans2[1]);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private long ccw(long[] a, long[] b, long[] c) {
        return (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]);
    }

    private long dist(long[] a, long[] b) {
        return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
    }
}
