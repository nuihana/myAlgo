package BaekJoon.Solve2025.November.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem22864 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int res = 0, h = 0;
        for (int i = 1; i <= 24; i++) {
            if (h + a <= m) {
                res += b;
                h += a;
            } else {
                h -= c;
                if (h < 0) h = 0;
            }
        }
        System.out.print(res);

        br.close();
    }
}
