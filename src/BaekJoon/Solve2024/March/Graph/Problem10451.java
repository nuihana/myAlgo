package BaekJoon.Solve2024.March.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem10451 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (caseCnt-- > 0) {
            int numCnt = Integer.parseInt(br.readLine());

            int[] graph = new int[numCnt + 1];
            boolean[] isVisited = new boolean[numCnt + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= numCnt; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }

            int res = 0;
            for (int i = 1; i <= numCnt; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;

                    Queue<Integer> q = new LinkedList<>();
                    q.offer(i);
                    while (!q.isEmpty()) {
                        int now = q.poll();

                        if (graph[now] == i) {
                            res++;
                            break;
                        }

                        q.offer(graph[now]);
                        isVisited[graph[now]] = true;
                    }
                }
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
