package BaekJoon.Solve2023.June.PhaseAlignment;

import java.io.*;
import java.util.*;

public class Problem3665 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseCnt; i++) {
            int teamCnt = Integer.parseInt(br.readLine());
            int[] teamGraph = new int[teamCnt + 1];
            int[] beforeRank = new int[teamCnt + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= teamCnt; j++) {
                beforeRank[j] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] list = new ArrayList[teamCnt + 1];
            for (int j = 1; j <= teamCnt; j++) {
                list[j] = new ArrayList<>();
            }

            for (int j = 1; j <= teamCnt; j++) {
                int before = beforeRank[j];
                for (int k = j + 1; k <= teamCnt; k++) {
                    int after = beforeRank[k];
                    teamGraph[after]++;

                    list[before].add(after);
                }
            }

            int upperCnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < upperCnt; j++) {
                st = new StringTokenizer(br.readLine());
                int before = Integer.parseInt(st.nextToken());
                int after = Integer.parseInt(st.nextToken());

                if (list[before].contains(after)) {
                    list[before].remove((Integer) after);
                    list[after].add(before);
                    teamGraph[before]++;
                    teamGraph[after]--;
                } else {
                    list[after].remove((Integer) before);
                    list[before].add(after);
                    teamGraph[after]++;
                    teamGraph[before]--;
                }
            }

            Queue<Integer> que = new LinkedList<>();
            Queue<Integer> result = new LinkedList<>();

            int cnt = 0;
            for (int j = 1; j <= teamCnt; j++) {
                if (teamGraph[j] == 0) {
                    cnt++;
                    que.offer(j);
                }
            }

            if (cnt > 1) {
                bw.write("?");
                bw.newLine();
                continue;
            }

            boolean isFinished = false;
            for (int j = 1; j <= teamCnt; j++) {
                if (que.isEmpty()) {
                    bw.write("IMPOSSIBLE");
                    bw.newLine();
                    isFinished = true;
                    break;
                }

                int from = que.poll();
                result.offer(from);
                for (int next : list[from]) {
                    teamGraph[next]--;
                    if (teamGraph[next] == 0) que.add(next);
                }
            }

            if (isFinished) continue;

            while(!result.isEmpty()) {
                bw.write(result.poll() + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
