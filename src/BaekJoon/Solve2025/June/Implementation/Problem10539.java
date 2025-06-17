package BaekJoon.Solve2025.June.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10539 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] b = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int now = b[i] * (i + 1);

            sb.append(now - sum).append(" ");
            sum += now - sum;
        }
        System.out.print(sb);

        br.close();
    }
}
