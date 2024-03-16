package BaekJoon.Solve2024.March.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem8979 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nationCnt = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());

        List<int[]> medalList = new ArrayList<>();
        for (int i = 0; i < nationCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            medalList.add(new int[]{ idx, gold, silver, bronze });
        }
        medalList.sort((a1, a2) -> {
            if (a1[1] != a2[1]) return a2[1] - a1[1];
            if (a1[2] != a2[2]) return a2[2] - a1[2];
            return a2[3] - a1[3];
        });

        int ord = 1, same = 1;
        int res = 0;
        for (int i = 0; i < medalList.size(); i++) {
            int[] now = medalList.get(i);
            if (now[0] == query) {
                res = ord;
                break;
            }

            if (i < medalList.size() - 1) {
                int[] next = medalList.get(i + 1);

                if (now[1] == next[1] && now[2] == next[2] && now[3] == next[3]) {
                    same++;
                } else {
                    ord += same;
                    same = 1;
                }
            }
        }

        System.out.print(res);

        br.close();
    }
}
