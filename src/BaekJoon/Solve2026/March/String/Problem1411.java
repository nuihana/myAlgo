package BaekJoon.Solve2026.March.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem1411 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Map<Character, Integer> cnt = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            for (int j = 0, id = 1; j < str.length(); j++) {
                char c = str.charAt(j);

                if (cnt.containsKey(c)) {
                    sb.append(cnt.get(c));
                } else {
                    sb.append(id);
                    cnt.put(c, id++);
                }
            }

            String key = sb.toString();
            if (map.containsKey(key)) {
                res += map.get(key);
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        System.out.print(res);

        br.close();
    }
}
