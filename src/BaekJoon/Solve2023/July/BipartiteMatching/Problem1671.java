package BaekJoon.Solve2023.July.BipartiteMatching;

import java.io.*;
import java.util.*;

public class Problem1671 {
    List<List<Integer>> list;
    int[] feedIdx;
    boolean[] done;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        int[][] shark = new int[cnt][3];
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            shark[i][0] = Integer.parseInt(st.nextToken());
            shark[i][1] = Integer.parseInt(st.nextToken());
            shark[i][2] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            List<Integer> tmp = new ArrayList<>();
            int[] now = shark[i];
            for (int j = 0; j < cnt; j++) {
                if (i == j) continue;
                int[] cpr = shark[j];
                if (now[0] < cpr[0]) continue;
                if (now[1] < cpr[1]) continue;
                if (now[2] < cpr[2]) continue;
                if (now[0] == cpr[0] && now[1] == cpr[1] && now[2] == cpr[2] && i > j) continue;
                tmp.add(j);
            }
            list.add(tmp);
        }

        int res = 0;
        feedIdx = new int[cnt];
        Arrays.fill(feedIdx, -1);
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < 2; j++) {
                done = new boolean[cnt];
                if (dfs(i)) res++;
            }
        }

        bw.write(String.valueOf(cnt - res));

        br.close();
        bw.close();
    }

    private boolean dfs(int n) {
        if (done[n]) return false;
        done[n] = true;

        for (int i : list.get(n)) {
            if (feedIdx[i] == -1 || dfs(feedIdx[i])) {
                feedIdx[i] = n;
                return true;
            }
        }
        return false;
    }
}
