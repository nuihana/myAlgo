package BaekJoon.Solve2025.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1813 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[51];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cnt[Integer.parseInt(st.nextToken())]++;
        }

        int res = -1;
        for (int i = 50; i >= 0; i--) {
            if (cnt[i] == i) {
                res = i;
                break;
            }
        }
        System.out.print(res);

        br.close();
    }
}
