package BaekJoon.Solve2023.July.BipartiteMatching;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1867 {
    List<List<Integer>> list;
    int[] match;
    boolean[] done;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
        }

        int res = 0;
        match = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            done = new boolean[size + 1];
            if (dfs(i)) res++;
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }

    private boolean dfs(int n) {
        if (done[n]) return false;
        done[n] = true;

        for (int i : list.get(n)) {
            if (match[i] == 0 || dfs(match[i])) {
                match[i] = n;
                return true;
            }
        }
        return false;
    }
}
