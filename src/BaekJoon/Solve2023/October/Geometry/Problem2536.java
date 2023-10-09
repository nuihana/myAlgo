package BaekJoon.Solve2023.October.Geometry;

import java.io.*;
import java.util.*;

public class Problem2536 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int busCnt = Integer.parseInt(br.readLine());

        Bus[] busInfo = new Bus[busCnt];

        for (int i = 0; i < busCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            busInfo[i] = new Bus(Math.min(x1, x2), Math.min(y1, y2), Math.max(x1, x2), Math.max(y1, y2));
        }

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int dx = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());

        int[] visited = new int[busCnt];
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < busCnt; i++) {
            if (busInfo[i].is_in(sx, sy)) {
                que.offer(i);
                visited[i] = 1;
            }
        }

        int res = 0;
        while (!que.isEmpty()) {
            int idx = que.poll();
            if (busInfo[idx].is_in(dx, dy)) {
                res = visited[idx];
                break;
            }

            for (int i = 0; i < busCnt; i++) {
                if (visited[i] > 0) continue;
                if (busInfo[idx].is_in(busInfo[i])) {
                    visited[i] = visited[idx] + 1;
                    que.offer(i);
                }
            }
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }

    class Bus {
        int x1;
        int y1;
        int x2;
        int y2;

        public Bus(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }

        public boolean is_in(int x, int y) {
            return x >= x1 && x <= x2 && y >= y1 && y <= y2;
        }
        public boolean is_in(Bus a) {
            return a.x1 <= x2 && a.x2 >= x1 && a.y1 <= y2 && a.y2 >= y1;
        }
    }
}
