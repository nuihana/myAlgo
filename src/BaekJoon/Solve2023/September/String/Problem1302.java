package BaekJoon.Solve2023.September.String;

import java.io.*;
import java.util.*;

public class Problem1302 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            String str = br.readLine();
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
                continue;
            }
            map.put(str, 1);
        }

        List<String> list = new ArrayList<>();
        int max = 0;
        for (String str : map.keySet()) {
            if (max < map.get(str)) {
                max = map.get(str);
                list.clear();
                list.add(str);
                continue;
            }

            if (max == map.get(str)) {
                list.add(str);
            }
        }

        list.sort(Comparator.naturalOrder());
        for (String res : list) {
            bw.write(res);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
