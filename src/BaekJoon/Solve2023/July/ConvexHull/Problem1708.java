package BaekJoon.Solve2023.July.ConvexHull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem1708 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        List<long[]> pointList = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            pointList.add(new long[]{x, y, 0, 0});
        }

        pointList.sort((a1, a2) -> {
            if (a1[1] != a2[1]) return Long.compare(a1[1], a2[1]);
            return Long.compare(a1[0], a2[0]);
        }); // y 작은 순서 sort
        long[] start = pointList.get(0);
        for (int i = 1; i < cnt; i++) { // 기준점과의 상대 위치 계산
            long[] now = pointList.get(i);
            // 기준점 - 현재점 벡터
            now[2] = now[0] - start[0];
            now[3] = now[1] - start[1];
        }

        pointList.sort((a1, a2) -> { // 반시계방향으로 정렬
            if (a1[3] * a2[2] != a1[2] * a2[3]) return Long.compare(a1[3] * a2[2], a1[2] * a2[3]);
            if (a1[1] != a2[1]) return Long.compare(a1[1], a2[1]);
            return Long.compare(a1[0], a2[0]);
        });

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(1);

        int next = 2;

        while (next < cnt) {
            while (stack.size() >= 2) {
                int second = stack.pop();
                int first = stack.peek();

                if (ccw(pointList.get(first), pointList.get(second), pointList.get(next)) > 0) {
                    stack.push(second);
                    break;
                }
            }

            stack.push(next++);
        }

        bw.write(String.valueOf(stack.size()));

        br.close();
        bw.close();
    }

    private long ccw(long[] a, long[] b, long[] c) {
        return a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - b[0] * a[1] - c[0] * b[1] - a[0] * c[1];
    }
}
