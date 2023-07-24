package BaekJoon.Solve2023.July.BipartiteMatching;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem11376 {
    List<List<Integer>> list;
    boolean[] done;
    int[] todoIdx;
    int[] workCnt;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int worker = Integer.parseInt(st.nextToken());
        int todo = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= worker; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= worker; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cnt; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        int res = 0;
        todoIdx = new int[todo + 1];
        for (int i = 1; i <= worker; i++) {
            for (int j = 0; j < 2; j++) {
                done = new boolean[worker + 1];
                if (dfs(i)) res++;
            }
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }

    private boolean dfs(int n) {
        if (done[n]) return false;
        done[n] = true;

        for (int work : list.get(n)) {
            if (todoIdx[work] == 0 || dfs(todoIdx[work])) {
                todoIdx[work] = n;
                return true;
            }
        }

        return false;
    }
}
