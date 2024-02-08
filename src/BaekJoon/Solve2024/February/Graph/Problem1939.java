package BaekJoon.Solve2024.February.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1939 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int islandCnt = Integer.parseInt(st.nextToken());
        int bridgeCnt = Integer.parseInt(st.nextToken());

        int low = 0, high = 0;
        List<int[]>[] bridge = new List[islandCnt + 1];
        for (int i = 1; i <= islandCnt; i++) bridge[i] = new ArrayList<>();
        for (int i = 0; i < bridgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int capacity = Integer.parseInt(st.nextToken());

            bridge[from].add(new int[]{ to, capacity });
            bridge[to].add(new int[]{ from, capacity });
            high = Math.max(high, capacity);
        }

        st = new StringTokenizer(br.readLine());
        int source = Integer.parseInt(st.nextToken());
        int sink = Integer.parseInt(st.nextToken());

        while (low <= high) {
            boolean[] visit = new boolean[islandCnt + 1];
            int mid = (low + high) / 2;

            Queue<Integer> q = new LinkedList<>();
            q.offer(source);

            int newMid = -1;
            while (!q.isEmpty()) {
                int now = q.poll();
                if (now == sink) {
                    newMid = mid + 1;
                    break;
                }

                for (int[] next : bridge[now]) {
                    if (next[1] >= mid && !visit[next[0]]) {
                        visit[next[0]] = true;
                        q.offer(next[0]);
                    }
                }
            }
            if (newMid == -1) newMid = mid - 1;

            if (newMid == mid - 1) high = newMid;
            else if (newMid == mid + 1) low = newMid;
        }

        System.out.print(high);

        br.close();
    }
}
