package BaekJoon.Solve2024.March.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2660 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int memCnt = Integer.parseInt(br.readLine());
        int[][] arr = new int[memCnt + 1][memCnt + 1];
        for (int i = 1; i <= memCnt; i++) {
            Arrays.fill(arr[i], memCnt);
            arr[i][i] = 0;
        }
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for (int k = 1; k <= memCnt; k++) {
            for (int i = 1; i <= memCnt; i++) {
                for (int j = 1; j <= memCnt; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int min = memCnt;
        List<Integer> candidate = new ArrayList<>();
        for (int i = 1; i <= memCnt; i++) {
            int score = 0;
            for (int j = 1; j <= memCnt; j++) {
                score = Math.max(score, arr[i][j]);
            }

            if (min > score) {
                min = score;
                candidate.clear();
                candidate.add(i);
            } else if (min == score) {
                candidate.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(candidate.size()).append("\n");
        candidate.sort(Comparator.naturalOrder());
        for (int mem : candidate) {
            sb.append(mem).append(" ");
        }
        System.out.print(sb);

        br.close();
    }
}
