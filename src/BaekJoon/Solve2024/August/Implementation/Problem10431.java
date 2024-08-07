package BaekJoon.Solve2024.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10431 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append(" ");

            int[] ord = new int[20];
            int swapCnt = 0;
            for (int j = 0; j < 20; j++) {
                int now = Integer.parseInt(st.nextToken());
                ord[j] = now;
                for (int k = j - 1, l = j; k >= 0; k--, l--) {
                    if (ord[k] < ord[l]) break;
                    ord[l] = ord[k];
                    ord[k] = now;
                    swapCnt++;
                }
            }

            sb.append(swapCnt).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
