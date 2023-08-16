package BaekJoon.Solve2023.August.Random;

import java.io.*;
import java.util.StringTokenizer;

public class Problem9466 {
    int soloCnt;
    int[] arr;
    boolean[] visited, finished;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            arr = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[n + 1];
            finished = new boolean[n + 1];

            soloCnt = n;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            bw.write(String.valueOf(soloCnt));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private void dfs(int idx) {
        visited[idx] = true;

        int nextId = arr[idx];
        if (!visited[nextId]) {
            dfs(nextId);
        } else {
            if (!finished[nextId]) {
                soloCnt--;

                while (nextId != idx) {
                    nextId = arr[nextId];
                    soloCnt--;
                }
            }
        }

        finished[idx] = true;
    }
}
