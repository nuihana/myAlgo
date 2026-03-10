package BaekJoon.Solve2026.March.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem14247 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long res = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            res += Integer.parseInt(st.nextToken());
        }

        Integer[] grow = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            grow[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(grow, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            res += grow[i] * (n - i - 1);
        }
        System.out.print(res);

        br.close();
    }
}
