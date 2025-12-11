package BaekJoon.Solve2025.December.PartSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem21318 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        int bf = Integer.parseInt(st.nextToken());
        for (int i = 2, cnt = 0; i <= n; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (bf > now) cnt++;
            bf = now;
            arr[i] = cnt;
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            sb.append(arr[to] - arr[from]);
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
