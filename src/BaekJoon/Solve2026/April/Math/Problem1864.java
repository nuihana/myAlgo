package BaekJoon.Solve2026.April.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem1864 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> map = new HashMap<>();
        map.put('-', 0);
        map.put('\\', 1);
        map.put('(', 2);
        map.put('@', 3);
        map.put('?', 4);
        map.put('>', 5);
        map.put('&', 6);
        map.put('%', 7);
        map.put('/', -1);

        StringBuilder sb = new StringBuilder();
        while (true) {
            String src = br.readLine();
            if ("#".equals(src)) break;

            int res = 0;
            for (int i = src.length() - 1, idx = 0; i >= 0; i--) {
                char c = src.charAt(i);

                int tmp = map.get(c);
                tmp *= Math.pow(8, idx++);
                res += tmp;
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
