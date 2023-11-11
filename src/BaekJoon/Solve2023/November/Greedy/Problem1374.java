package BaekJoon.Solve2023.November.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1374 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list.add(new int[]{ from, idx, 0 });
            list.add(new int[]{ to, idx, 1 });
        }

        list.sort((a1, a2) -> a1[0] != a2[0] ? a1[0] - a2[0] : a2[2] - a1[2]);
        int res = 0;
        Set<Integer> room = new HashSet<>();
        for (int[] clas : list) {
            if (clas[2] == 0) room.add(clas[1]);
            if (clas[2] == 1) room.remove(clas[1]);
            res = Math.max(res, room.size());
        }

        System.out.print(res);

        br.close();
    }
}
