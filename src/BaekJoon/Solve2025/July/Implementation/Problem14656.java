package BaekJoon.Solve2025.July.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14656 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int res = 0;
        for (int i = 1; i <= n; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (now != i) res++;
        }

        System.out.print(res);

        br.close();
    }
}
