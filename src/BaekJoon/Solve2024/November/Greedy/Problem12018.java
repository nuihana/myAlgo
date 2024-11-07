package BaekJoon.Solve2024.November.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem12018 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] minCost = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] students = new int[p];
            for (int j = 0; j < p; j++) {
                students[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(students);

            if (p < l) {
                minCost[i] = 1;
            } else {
                minCost[i] = students[p - l];
            }
        }

        Arrays.sort(minCost);
        int res = 0;
        int use = 0;
        for (int i = 0; i < n; i++) {
            if (use + minCost[i] <= m) {
                res++;
                use += minCost[i];
            }
        }

        System.out.print(res);

        br.close();
    }
}
