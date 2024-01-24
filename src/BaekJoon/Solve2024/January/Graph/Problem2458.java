package BaekJoon.Solve2024.January.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2458 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentCnt = Integer.parseInt(st.nextToken());
        int cprCnt = Integer.parseInt(st.nextToken());

        List<Integer>[] forward = new List[studentCnt + 1];
        List<Integer>[] backward = new List[studentCnt + 1];
        for (int i = 1; i <= studentCnt; i++) {
            forward[i] = new ArrayList<>();
            backward[i] = new ArrayList<>();
        }

        for (int i = 0; i < cprCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int smaller = Integer.parseInt(st.nextToken());
            int bigger = Integer.parseInt(st.nextToken());

            forward[smaller].add(bigger);
            backward[bigger].add(smaller);
        }

        int res = 0;
        Queue<Integer> que = new LinkedList<>();
        for (int idx = 1; idx <= studentCnt; idx++) {
            boolean[] isDefined = new boolean[studentCnt + 1];
            for (int next : forward[idx]) {
                isDefined[next] = true;
                que.offer(next);
            }

            while (!que.isEmpty()) {
                int now = que.poll();
                for (int next : forward[now]) {
                    if (!isDefined[next]) {
                        isDefined[next] = true;
                        que.offer(next);
                    }
                }
            }

            for (int prev : backward[idx]) {
                isDefined[prev] = true;
                que.offer(prev);
            }

            while (!que.isEmpty()) {
                int now = que.poll();
                for (int prev : backward[now]) {
                    if (!isDefined[prev]) {
                        isDefined[prev] = true;
                        que.offer(prev);
                    }
                }
            }

            int definedCnt = 0;
            for (int i = 1; i <= studentCnt; i++) {
                if (isDefined[i]) definedCnt++;
            }

            if (definedCnt == studentCnt - 1) {
                res++;
            }
        }

        System.out.print(res);

        br.close();
    }
}
