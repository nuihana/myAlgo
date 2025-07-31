package BaekJoon.Solve2025.July.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10409 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] times = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + times[i] <= t) {
                res++;
                sum += times[i];
            }
        }
        System.out.print(res);

        br.close();
    }
}
