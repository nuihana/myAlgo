package BaekJoon.Solve2024.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2506 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int res = 0;
        for (int i = 0, before = 0; i < n; i++) {
            int ans = Integer.parseInt(st.nextToken());
            if (ans == 0) {
                before = 0;
            } else {
                res += ++before;
            }
        }
        System.out.print(res);

        br.close();
    }
}
