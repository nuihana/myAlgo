package BaekJoon.Solve2024.December.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem25418 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] isVisited = new boolean[1000001];
        Queue<int[]> q = new LinkedList<>();
        isVisited[a] = true;
        q.offer(new int[]{a, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == k) {
                System.out.print(now[1]);
                break;
            }

            if (now[0] + 1 <= 1000000 && !isVisited[now[0] + 1]) {
                isVisited[now[0] + 1] = true;
                q.offer(new int[]{now[0] + 1, now[1] + 1});
            }

            if (now[0] * 2 <= 1000000 && !isVisited[now[0] * 2]) {
                isVisited[now[0] * 2] = true;
                q.offer(new int[]{now[0] * 2, now[1] + 1});
            }
        }

        br.close();
    }
}
