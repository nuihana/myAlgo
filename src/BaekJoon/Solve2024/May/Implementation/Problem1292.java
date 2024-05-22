package BaekJoon.Solve2024.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1292 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int[] arr = new int[1001];
        int idx = 1;
        int val = 1;
        while (idx <= 1000) {
            for (int i = 0; i < val; i++) {
                if (idx == 1001) break;
                arr[idx++] = val;
            }
            val++;
        }

        int res = 0;
        for (int i = from; i <= to; i++) {
            res += arr[i];
        }
        System.out.print(res);

        br.close();
    }
}
