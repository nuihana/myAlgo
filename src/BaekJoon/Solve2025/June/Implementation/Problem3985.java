package BaekJoon.Solve2025.June.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3985 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[] cake = new int[l + 1];
        int res1 = 0, tmp1 = 0, res2 = 0, tmp2 = 0;
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (to - from > tmp1) {
                res1 = i;
                tmp1 = to - from;
            }

            int cnt = 0;
            for (int j = from; j <= to; j++) {
                if (cake[j] == 0) {
                    cake[j] = i;
                    cnt++;
                }
            }

            if (cnt > tmp2) {
                res2 = i;
            }
        }

        System.out.println(res1);
        System.out.print(res2);

        br.close();
    }
}
