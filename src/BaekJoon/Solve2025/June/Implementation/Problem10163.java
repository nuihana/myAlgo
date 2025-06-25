package BaekJoon.Solve2025.June.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10163 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[1001][1001];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());

            for (int x = 0; x < dx; x++) {
                for (int y = 0; y < dy; y++) {
                    map[sx + x][sy + y] = i;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int x = 0; x <= 1000; x++) {
                for (int y = 0; y <= 1000; y++) {
                    if (map[x][y] == i) cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
