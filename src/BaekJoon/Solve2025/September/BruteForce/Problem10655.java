package BaekJoon.Solve2025.September.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10655 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] chkP = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            chkP[i][0] = Integer.parseInt(st.nextToken());
            chkP[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] term = new int[n - 1];
        int tot = 0;
        for (int i = 1; i < n; i++) {
            term[i - 1] = len(chkP, i, i - 1);
            tot += term[i - 1];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            res = Math.min(res, tot - term[i - 1] - term[i] + len(chkP, i + 1, i - 1));
        }
        System.out.print(res);

        br.close();
    }

    private int len(int[][] p, int a, int b) {
        return Math.abs(p[a][0] - p[b][0]) + Math.abs(p[a][1] - p[b][1]);
    }
}
