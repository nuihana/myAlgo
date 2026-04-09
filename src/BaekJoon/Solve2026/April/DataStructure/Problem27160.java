package BaekJoon.Solve2026.April.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem27160 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            map.compute(key, (k, v) -> v == null ? value : v + value);
        }

        boolean need = false;
        for (String key : map.keySet()) {
            if (map.get(key) == 5) need = true;
        }

        if (need) System.out.print("YES");
        else System.out.print("NO");

        br.close();
    }
}
