package BaekJoon.Solve2025.November.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem25644 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int res = 0, tmp = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());

            if (a < tmp) tmp = a;
            else res = Math.max(res, a - tmp);
        }
        System.out.print(res);

        br.close();
    }
}
