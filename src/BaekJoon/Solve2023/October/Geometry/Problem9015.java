package BaekJoon.Solve2023.October.Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem9015 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        Set<Integer>[] set = new Set[20001];
        for (int i = 0; i <= 20000; i++) set[i] = new HashSet<>();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> p = new ArrayList<>();
            for (int i = 0; i <= 20000; i++) set[i].clear();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                x += 10000;
                y += 10000;
                p.add(new int[]{ x, y });
                set[x].add(y);
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int[] p1 = p.get(i);
                    int[] p2 = p.get(j);

                    int dx = p1[0] - p2[0];
                    int dy = p1[1] - p2[1];

                    int[] p3 = { p1[0] + dy, p1[1] - dx };
                    int[] p4 = { p2[0] + dy, p2[1] - dx };

                    if (!isInRange(p3[0]) || !isInRange(p3[1]) || !isInRange(p4[0]) || !isInRange(p4[1])) continue;

                    if (set[p3[0]].contains(p3[1]) && set[p4[0]].contains(p4[1])) {
                        ans = Math.max(ans, dx * dx + dy * dy);
                    }
                }
            }

            System.out.println(ans);
        }

        br.close();
    }

    private boolean isInRange(int n) {
        return n >= 0 && n <= 20000;
    }
}
