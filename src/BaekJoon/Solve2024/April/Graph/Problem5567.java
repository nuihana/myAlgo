package BaekJoon.Solve2024.April.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem5567 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int friendCnt = Integer.parseInt(br.readLine());
        int relationCnt = Integer.parseInt(br.readLine());
        boolean[] isCome = new boolean[friendCnt + 1];

        List<Integer>[] relation = new List[friendCnt + 1];
        for (int i = 1; i <= friendCnt; i++) {
            relation[i] = new ArrayList<>();
        }

        while (relationCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a].add(b);
            relation[b].add(a);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ 1, 0 });
        isCome[1] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[1] >= 2) continue;
            for (int next : relation[now[0]]) {
                if (!isCome[next]) {
                    isCome[next] = true;
                    q.offer(new int[]{ next, now[1] + 1 });
                }
            }
        }

        int res = 0;
        for (int i = 2; i <= friendCnt; i++) {
            if (isCome[i]) res++;
        }

        System.out.print(res);

        br.close();
    }
}
