package BaekJoon.Solve2025.November.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem23253 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int bottom = Integer.parseInt(st.nextToken());
            for (int j = 1; j < k; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[bottom] = val;
                bottom = val;
            }
        }

        boolean isPossible = true;
        for (int i = 1; i <= n; i++) {
            if (arr[i] > i) isPossible = false;
        }

        if (isPossible) System.out.print("Yes");
        else System.out.print("No");

        br.close();
    }
}
