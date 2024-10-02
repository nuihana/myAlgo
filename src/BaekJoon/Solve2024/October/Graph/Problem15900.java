package BaekJoon.Solve2024.October.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem15900 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCnt = Integer.parseInt(br.readLine());
        List<Integer>[] tree = new List[nodeCnt + 1];
        for (int i = 1; i <= nodeCnt; i++) tree[i] = new ArrayList<>();
        for (int i = 1; i < nodeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        boolean[] isVisit = new boolean[nodeCnt + 1];
        Queue<int[]> q = new LinkedList<>();
        isVisit[1] = true;
        q.offer(new int[]{ 1, 0 });
        int needCnt = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            boolean isLeaf = true;
            for (int next : tree[now[0]]) {
                if (!isVisit[next]) {
                    isVisit[next] = true;
                    q.offer(new int[]{ next, now[1] + 1 });
                    isLeaf = false;
                }
            }

            if (isLeaf) {
                needCnt += now[1];
            }
        }

        if (needCnt % 2 == 0) {
            System.out.print("No");
        } else {
            System.out.print("Yes");
        }

        br.close();
    }
}
