package BaekJoon.Solve2026.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem5533 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        int[][] record = new int[101][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            record[arr[i][0]][0]++;
            arr[i][1] = Integer.parseInt(st.nextToken());
            record[arr[i][1]][1]++;
            arr[i][2] = Integer.parseInt(st.nextToken());
            record[arr[i][2]][2]++;
        }

        int[] res = new int[n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                if (record[arr[j][i]][i] == 1) res[j] += arr[j][i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(res[i]).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
