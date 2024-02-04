package BaekJoon.Solve2024.February.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem5014 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalFloor = Integer.parseInt(st.nextToken());
        int from = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        int[] isVisited = new int[totalFloor + 1];
        Arrays.fill(isVisited, 1000001);
        q.offer(new int[]{ from, 0 });
        isVisited[from] = 0;
        int res = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == end) {
                res = Math.min(res, now[1]);
            }

            if (now[0] + up <= totalFloor && isVisited[now[0] + up] > now[1] + 1) {
                isVisited[now[0] + up] = now[1] + 1;
                q.offer(new int[]{ now[0] + up, now[1] + 1 });
            }

            if (now[0] - down > 0 && isVisited[now[0] - down] > now[1] + 1) {
                isVisited[now[0] - down] = now[1] + 1;
                q.offer(new int[]{ now[0] - down, now[1] + 1 });
            }
        }

        System.out.print(res == Integer.MAX_VALUE ? "use the stairs" : res);

        br.close();
    }
}
