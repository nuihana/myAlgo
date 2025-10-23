package BaekJoon.Solve2025.October.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem1270 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            Map<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < t; i++) {
                long val = Long.parseLong(st.nextToken());
                map.compute(val, (k, v) -> v == null ? 1 : v + 1);
            }

            boolean isDraw = false;
            long conquer = 0, cnt = 0;
            for (long key : map.keySet()) {
                if (map.get(key) > cnt) {
                    isDraw = false;
                    conquer = key;
                    cnt = map.get(key);
                } else if (map.get(key) == cnt) {
                    isDraw = true;
                }
            }

            if (!isDraw && cnt > t / 2) {
                sb.append(conquer).append("\n");
            } else {
                sb.append("SYJKGW").append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
