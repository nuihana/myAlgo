package BaekJoon.Solve2024.February.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem11652 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCnt = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        while (numCnt-- > 0) {
            long val = Long.parseLong(br.readLine());
            map.compute(val, (k, v) -> v == null ? 1 : v + 1);
        }

        long res = Long.MAX_VALUE;
        int cnt = -1;
        for (Long key : map.keySet()) {
            if (map.get(key) > cnt) {
                cnt = map.get(key);
                res = key;
            } else if (map.get(key) == cnt){
                res = Math.min(res, key);
            }
        }

        System.out.print(res);

        br.close();
    }
}
