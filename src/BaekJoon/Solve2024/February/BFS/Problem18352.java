package BaekJoon.Solve2024.February.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem18352 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityCnt = Integer.parseInt(st.nextToken());
        int roadCnt = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        List<Integer>[] road = new List[cityCnt + 1];
        for (int i = 1; i <= cityCnt; i++) road[i] = new ArrayList<>();

        for (int i = 0; i < roadCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            road[from].add(to);
        }

        int[] res = new int[cityCnt + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ start, 0 });
        res[start] = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int next : road[now[0]]) {
                if (res[next] > now[1] + 1) {
                    res[next] = now[1] + 1;
                    q.offer(new int[]{ next, now[1] + 1 });
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean isExist = false;
        for (int i = 1; i <= cityCnt; i++) {
            if (res[i] == distance) {
                isExist = true;
                sb.append(i).append("\n");
            }
        }

        if (isExist) {
            System.out.print(sb);
        } else {
            System.out.print("-1");
        }

        br.close();
    }
}
