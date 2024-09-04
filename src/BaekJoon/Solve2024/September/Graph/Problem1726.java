package BaekJoon.Solve2024.September.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1726 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] start = new int[3];
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());
        start[2] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] end = new int[3];
        end[0] = Integer.parseInt(st.nextToken());
        end[1] = Integer.parseInt(st.nextToken());
        end[2] = Integer.parseInt(st.nextToken());

        System.out.print(getShortestRoute(start, end, map));

        br.close();
    }

    private int getShortestRoute(int[] start, int[]end, int[][] map) {
        int r = map.length;
        int c = map[0].length;
        int[] dx = { 0, 0, 0, 1, -1 };
        int[] dy = { 0, 1, -1, 0, 0 };
        int[][][] isVisit = new int[r][c][5];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Arrays.fill(isVisit[i][j], Integer.MAX_VALUE);
            }
        }
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{ start[0], start[1], start[2], 0 });
        isVisit[start[0]][start[1]][start[2]] = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            //제자리 회전
            for (int i = 1; i <= 4; i++) {
                int nc = dirCost(now[2], i);
                isVisit[now[0]][now[1]][i] = Math.min(isVisit[now[0]][now[1]][i], now[3] + nc);
            }

            //이동
            for (int i = 1; i <= 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int nc = now[3] + dirCost(now[2], i) + 1;
                for (int j = 1; j <= 3; j++) {
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] == 1 || isVisit[nx][ny][i] < nc) break;
                    isVisit[nx][ny][i] = nc;
                    q.offer(new int[]{ nx, ny, i, nc });
                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }

        return isVisit[end[0]][end[1]][end[2]];
    }

    private int dirCost(int bf, int af) {
        if (bf == af) return 0;

        if (bf == 1) {
            if (af == 2) {
                return 2;
            } else {
                return 1;
            }
        } else if (bf == 2) {
            if (af == 1) {
                return 2;
            } else {
                return 1;
            }
        } else if (bf == 3) {
            if (af == 4) {
                return 2;
            } else {
                return 1;
            }
        } else {
            if (af == 3) {
                return 2;
            } else {
                return 1;
            }
        }
    }
}
