package BaekJoon.Solve2025.November.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2891 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] cnt = new int[n + 2];
        Arrays.fill(cnt, 1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            cnt[Integer.parseInt(st.nextToken())]--;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            cnt[Integer.parseInt(st.nextToken())]++;
        }

        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 2) {
                if (i > 1 && cnt[i - 1] == 0) cnt[i - 1]++;
                else if (cnt[i + 1] == 0) cnt[i + 1]++;
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) res++;
        }

        System.out.print(res);

        br.close();
    }
}
