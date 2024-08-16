package BaekJoon.Solve2024.August.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem15970 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> dotGroup = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int group = Integer.parseInt(st.nextToken());

            dotGroup.compute(group, (k, v) -> v == null ? new ArrayList<>() : v);
            dotGroup.get(group).add(x);
        }

        int res = 0;
        for (List<Integer> v : dotGroup.values()) {
            v.sort(Comparator.naturalOrder());
        }

        for (List<Integer> v : dotGroup.values()) {
            for (int i = 0; i < v.size(); i++) {
                if (i == 0) {
                    res += v.get(i + 1) - v.get(i);
                } else if (i == v.size() - 1) {
                    res += v.get(i) - v.get(i - 1);
                } else {
                    res += Math.min(v.get(i + 1) - v.get(i), v.get(i) - v.get(i - 1));
                }
            }
        }

        System.out.print(res);

        br.close();
    }
}
