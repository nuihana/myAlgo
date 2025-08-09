package BaekJoon.Solve2025.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2774 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String src = br.readLine();
            int[] cnt = new int[10];
            for (int i = 0; i < src.length(); i++) {
                cnt[src.charAt(i) - '0']++;
            }

            int res = 0;
            for (int i = 0; i < 10; i++) {
                if (cnt[i] > 0) res++;
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
