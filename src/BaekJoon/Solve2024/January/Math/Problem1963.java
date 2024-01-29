package BaekJoon.Solve2024.January.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1963 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[10001];
        for (int i = 2; i <= 10000; i++) {
            for (int j = 2; i * j <= 10000; j++) {
                if (!prime[i * j]) prime[i * j] = true;
            }
        }

        List<Integer> primeList = new ArrayList<>();
        for (int i = 1000; i <= 10000; i++) {
            if (!prime[i]) primeList.add(i);
        }

        List<Integer>[] edgeList = new List[10001];
        for (int primeNum : primeList) {
            edgeList[primeNum] = new ArrayList<>();
            String primeStr = String.valueOf(primeNum);

            for (int another : primeList) {
                int same = 0;

                for (int i = 10; i <= 10000; i *= 10) {
                    if ((primeNum % i) / (i / 10) == (another % i) / (i / 10)) same++;
                }

                if (same == 3) edgeList[primeNum].add(another);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            boolean[] isVisited = new boolean[10001];
            Queue<int[]> q = new LinkedList<>();
            isVisited[from] = true;
            q.offer(new int[]{ from, 0 });

            int res = -1;
            while (!q.isEmpty()) {
                int[] now = q.poll();
                if (now[0] == to) {
                    res = now[1];
                    break;
                }

                for (int next : edgeList[now[0]]) {
                    if (!isVisited[next]) {
                        isVisited[next] = true;
                        q.offer(new int[]{ next, now[1] + 1 });
                    }
                }
            }

            sb.append(res >= 0 ? res : "Impossible").append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
