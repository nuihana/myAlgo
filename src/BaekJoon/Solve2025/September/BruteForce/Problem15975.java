package BaekJoon.Solve2025.September.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem15975 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map.compute(y, (k, v) -> v == null ? new ArrayList<>() : v).add(x);
        }

        long res = 0;
        for (List<Integer> list : map.values()) {
            if (list.size() == 1) continue;
            list.sort(Integer::compareTo);

            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    res += list.get(i + 1) - list.get(i);
                } else if (i == list.size() - 1) {
                    res += list.get(i) - list.get(i - 1);
                } else {
                    res += Math.min(list.get(i) - list.get(i - 1), list.get(i + 1) - list.get(i));
                }
            }
        }
        System.out.print(res);

        br.close();
    }
}
