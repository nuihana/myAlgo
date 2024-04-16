package BaekJoon.Solve2024.April.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem19238 {
    int size;
    int[][] map;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        int pur = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? -1 : 0;
            }
        }

        st = new StringTokenizer(br.readLine());
        Point now = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, -1);
        List<Point> customer = new ArrayList<>();
        List<Point> destination = new ArrayList<>();
        customer.add(new Point(0, 0, 0));
        destination.add(new Point(0, 0, 0));
        for (int i = 1; i <= pur; i++) {
            st = new StringTokenizer(br.readLine());

            int cx = Integer.parseInt(st.nextToken()) - 1;
            int cy = Integer.parseInt(st.nextToken()) - 1;
            customer.add(new Point(cx, cy, i));
            map[cx][cy] = i;
            destination.add(new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, i));
        }

        int cnt = 0;
        while (true) {
            // 제일 가까운 승객 번호
            int idx = getClosestCustomer(now);

            if (idx == -1) break;
            // 승객까지 이동
            int move = getDistance(now, customer.get(idx));
            fuel -= move;
            if (fuel < 0) break;

            // 목적지까지 이동
            move = getDistance(customer.get(idx), destination.get(idx));
            fuel -= move;
            if (fuel < 0) break;
            // 이동 후 처리
            map[customer.get(idx).x][customer.get(idx).y] = 0;
            fuel += move * 2;
            now = destination.get(idx);
            cnt++;
        }

        if (cnt == pur) System.out.print(fuel);
        else System.out.print("-1");

        br.close();
    }

    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    private int getClosestCustomer(Point taxi) {
        if (map[taxi.x][taxi.y] > 0) return map[taxi.x][taxi.y];

        Queue<Point> q = new LinkedList<>();
        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[size][size];
        q.offer(taxi);
        isVisited[taxi.x][taxi.y] = true;

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Point now = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if (nx < 0 || nx >= size || ny < 0 || ny >= size || isVisited[nx][ny] || map[nx][ny] < 0) continue;
                    if (map[nx][ny] > 0) pq.offer(new Point(nx, ny, map[nx][ny]));
                    q.offer(new Point(nx, ny, -1));
                    isVisited[nx][ny] = true;
                }
            }

            if (!pq.isEmpty()) {
                Point dest = pq.poll();
                return map[dest.x][dest.y];
            }
        }

        return -1;
    }

    private int getDistance(Point start, Point end) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[size][size];
        q.offer(start);
        isVisited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();
            if (end.isArrived(now)) {
                return now.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= size || ny < 0 || ny >= size || map[nx][ny] == -1 || isVisited[nx][ny]) continue;
                isVisited[nx][ny] = true;
                q.offer(new Point(nx, ny, -1, now.dist + 1));
            }
        }

        return Integer.MAX_VALUE; // 최대 이동거리
    }

    class Point implements Comparable<Point> {
        int x, y, dist, idx;
        public Point(int x_, int y_, int idx_) {
            x = x_;
            y = y_;
            idx = idx_;
            dist = 0;
        }
        public Point(int x_, int y_, int idx_, int dist_) {
            x = x_;
            y = y_;
            idx = idx_;
            dist = dist_;
        }

        public boolean isArrived(Point another) {
            return this.x == another.x && this.y == another.y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x != o.x) return this.x - o.x;
            return this.y - o.y;
        }
    }
}
