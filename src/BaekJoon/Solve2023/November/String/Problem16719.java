package BaekJoon.Solve2023.November.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem16719 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < src.length(); i++) {
            list.add(new int[]{ i, src.charAt(i) });
        }
        list.sort((a1, a2) -> {
            if (a1[1] != a2[1]) return a1[1] - a2[1];
            return a1[0] - a2[0];
        });

        boolean[] used = new boolean[src.length()];
        int idx = 0;
        while (true) {
            idx--;
            for (int i = idx; i >= 0; i--) {
                if (used[i]) break;
                idx--;
            }

            for (int i = 0; i < list.size(); i++) {
                if (!used[list.get(i)[0]] && list.get(i)[0] > idx) {
                    idx = list.get(i)[0];
                    used[idx] = true;

                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < used.length; j++) {
                        if (used[j]) sb.append(src.charAt(j));
                    }
                    System.out.println(sb);
                }
            }
            if (idx == -1) break;
        }

        br.close();
    }
}
