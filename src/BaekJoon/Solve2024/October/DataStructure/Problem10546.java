package BaekJoon.Solve2024.October.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem10546 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> player = new HashMap();
        for (int i = 0; i < n; i++) {
            String p = br.readLine();
            player.compute(p, (key, value) -> value == null ? 1 : value + 1);
        }

        for (int i = 0; i < n - 1; i++) {
            String complete = br.readLine();
            player.compute(complete, (key, value) -> value - 1);
        }

        for (String p : player.keySet()) {
            if (player.get(p) > 0) {
                System.out.print(p);
                return;
            }
        }

        br.close();
    }
}
