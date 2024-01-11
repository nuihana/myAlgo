package BaekJoon.Solve2024.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem17142 {
    int size, cnt, empty;
    int[] virus;
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };
    int[][] field;
    List<int[]> virusList;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        cnt = Integer.parseInt(st.nextToken());

        virus = new int[cnt];
        field = new int[size][size];
        virusList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                if (field[i][j] == 2) virusList.add(new int[]{ i, j });
                if (field[i][j] == 0) empty++;
            }
        }

        int result = setVirus(0, 0);
        System.out.print(result == Integer.MAX_VALUE ? -1 : result);

        br.close();
    }

    private int[][] copy() {
        int[][] tmp = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(field[i], 0, tmp[i], 0, size);
        }
        return tmp;
    }

    private int setVirus(int ord, int idx) {
        if (ord == cnt) return getTime();
        int res = Integer.MAX_VALUE;
        for (int i = idx; i < virusList.size(); i++) {
            virus[ord] = i;
            res = Math.min(res, setVirus(ord + 1, i + 1));
        }
        return res;
    }

    private int getTime() {
        Queue<int[]> que = new LinkedList<>();
        int[][] visit = copy();
        for (int idx : virus) {
            int[] now = virusList.get(idx);
            que.offer(new int[]{ now[0], now[1], 0 });
            visit[now[0]][now[1]] = 1;
        }
        for (int[] v : virusList) {
            visit[v[0]][v[1]] = 2;
        }

        int maxTime = 0;
        int fillEmptyCnt = 0;
        while (!que.isEmpty()) {
            int[] now = que.poll();
            if (fillEmptyCnt == empty) break;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= size || ny < 0 || ny >= size || visit[nx][ny] == 1) continue;
                if (visit[nx][ny] == 0) fillEmptyCnt++;
                visit[nx][ny] = 1;
                que.offer(new int[]{ nx, ny, now[2] + 1 });
                maxTime = Math.max(maxTime, now[2] + 1);
            }
        }

        if (fillEmptyCnt != empty) return Integer.MAX_VALUE;
        else return maxTime;
    }
}
