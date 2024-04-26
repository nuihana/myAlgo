package BaekJoon.Solve2024.April.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem10159 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCnt = Integer.parseInt(br.readLine());
        int edgeCnt = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new List[nodeCnt + 1];
        List<Integer>[] reverse = new List[nodeCnt + 1];

        for (int i = 1; i <= nodeCnt; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            reverse[to].add(from);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= nodeCnt; i++) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);

            boolean[] isComparable = new boolean[nodeCnt + 1];
            isComparable[i] = true;
            int cpr = 0;
            // 큰 것
            while (!q.isEmpty()) {
                int now = q.poll();
                cpr++;

                for (int next : reverse[now]) {
                    if (!isComparable[next]) {
                        isComparable[next] = true;
                        q.offer(next);
                    }
                }
            }

            cpr--; // 본인 중복 제거
            q.offer(i);
            //작은 것
            while (!q.isEmpty()) {
                int now = q.poll();
                cpr++;

                for (int next : graph[now]) {
                    if (!isComparable[next]) {
                        isComparable[next] = true;
                        q.offer(next);
                    }
                }
            }

            sb.append(nodeCnt - cpr).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
