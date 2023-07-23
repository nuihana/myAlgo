package BaekJoon.Solve2023.July.BipartiteMatching;

import java.io.*;
import java.util.*;

public class Problem11375 {
    List<List<Integer>> workList;
    int[] workIdx;
    boolean[] done;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int worker = Integer.parseInt(st.nextToken());
        int work = Integer.parseInt(st.nextToken());

        workList = new ArrayList<>();
        for (int i = 0; i <= worker; i++) {
            workList.add(new ArrayList<>());
        }

        for (int i = 1; i <= worker; i++) {
            st = new StringTokenizer(br.readLine());

            int possible = Integer.parseInt(st.nextToken());
            for (int j = 0; j < possible; j++) {
                int work_ = Integer.parseInt(st.nextToken());
                workList.get(i).add(work_);
            }
        }

        workIdx = new int[work + 1];
        done = new boolean[work + 1];
        int res = 0;
        for (int i = 1; i <= worker; i++) {
            if (dfs(i)) res++;
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }

    private boolean dfs(int n) {
        for (int i = 0; i < workList.get(n).size(); i++) {
            int work = workList.get(n).get(i);

            if (done[work]) continue;
            done[work] = true;

            if (workIdx[work] == 0 || dfs(workIdx[work])) {
                workIdx[work] = n;
                return true;
            }
        }
        return false;
    }
}
