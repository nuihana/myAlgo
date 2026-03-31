package BaekJoon.Solve2026.March.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem16968 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        map.put("d", 10);
        map.put("dd", 90);
        map.put("ddd", 810);
        map.put("dddd", 7290);
        map.put("c", 26);
        map.put("cc", 650);
        map.put("ccc", 16250);
        map.put("cccc", 406250);

        String src = br.readLine();
        String tmp = src.charAt(0) + "";
        int res = 1;
        for (int i = 1; i < src.length(); i++) {
            if (src.charAt(i) == src.charAt(i - 1)) {
                tmp += src.charAt(i);
            } else {
                res *= map.get(tmp);
                tmp = src.charAt(i) + "";
            }
        }
        res *= map.get(tmp);

        System.out.print(res);

        br.close();
    }
}
