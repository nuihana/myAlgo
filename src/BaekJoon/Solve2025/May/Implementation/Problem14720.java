package BaekJoon.Solve2025.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14720 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int res = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int var = 0;
        while (st.hasMoreTokens()) {
            int now = Integer.parseInt(st.nextToken());
            if (now == var) {
                res++;
                var = (var + 1) % 3;
            }
        }

        System.out.print(res);

        br.close();
    }
}
