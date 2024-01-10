package BaekJoon.Solve2024.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2960 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;

        int result = -1;
        int rmCnt = 0;
        while (result < 0) {
            int now = 0;
            for (int i = 2; i <= n; i++) {
                if (arr[i] == 0) {
                    now = i;
                    break;
                }
            }

            for (int i = 1; i * now <= n; i++) {
                int rm = i * now;
                if (arr[rm] == 1) continue;
                rmCnt++;
                arr[rm] = 1;
                if (rmCnt == k) {
                    result = rm;
                    break;
                }
            }
        }

        System.out.print(result);

        br.close();
    }
}
