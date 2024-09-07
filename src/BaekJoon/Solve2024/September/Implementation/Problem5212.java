package BaekJoon.Solve2024.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem5212 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        map = afterTime(map);
        map = minimizeMap(map);
        StringBuilder sb = new StringBuilder();
        for (char[] line : map) {
            for (char ch : line) {
                sb.append(ch);
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private char[][] afterTime(char[][] map) {
        int r = map.length;
        int c = map[0].length;

        char[][] afterMap = new char[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(map[i], 0, afterMap[i], 0, c);
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'X') {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                        if (map[nx][ny] == 'X') cnt++;
                    }

                    if (cnt < 2) afterMap[i][j] = '.';
                }
            }
        }

        return afterMap;
    }

    private char[][] minimizeMap(char[][] map) {
        int r = map.length;
        int c = map[0].length;
        int sr = Integer.MAX_VALUE, er = -1;
        int sc = Integer.MAX_VALUE, ec = -1;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'X') {
                    sr = Math.min(sr, i);
                    er = Math.max(er, i);
                    sc = Math.min(sc, j);
                    ec = Math.max(ec, j);
                }
            }
        }

        char[][] res = new char[er - sr + 1][ec - sc + 1];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = map[sr + i][sc + j];
            }
        }
        return res;
    }
}
