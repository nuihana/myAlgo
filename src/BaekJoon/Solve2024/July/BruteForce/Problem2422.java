package BaekJoon.Solve2024.July.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2422 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] uniq = new List[n + 1];
        for (int i = 1; i <= n; i++) uniq[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            uniq[a].add(b);
            uniq[b].add(a);
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (isOK(uniq, i, j, k)) res++;
                }
            }
        }

        System.out.print(res);

        br.close();
    }

    private boolean isOK(List<Integer>[] uniq, int a, int b, int c) {
        if (uniq[a].contains(b) || uniq[a].contains(c) || uniq[b].contains(c)) return false;
        return true;
    }
}
