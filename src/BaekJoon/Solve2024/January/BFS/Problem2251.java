package BaekJoon.Solve2024.January.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2251 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] buckets = new int[3];
        for (int i = 0; i < 3; i++) {
            buckets[i] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ 0, 0, buckets[2] });
        boolean[][] chk = new boolean[201][201];
        chk[0][0] = true;
        Set<Integer> res = new TreeSet<>();
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == 0) {
                res.add(now[2]);
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != j) {
                        int[] next = { now[0], now[1], now[2] };
                        if (now[i] + now[j] > buckets[j]) {
                            next[i] -= buckets[j] - now[j];
                            next[j] = buckets[j];
                        } else {
                            next[i] = 0;
                            next[j] = now[i] + now[j];
                        }

                        if (!chk[next[0]][next[1]]) {
                            chk[next[0]][next[1]] = true;
                            q.add(next);
                        }
                    }
                }
            }
        }

        for (int num : res) System.out.print(num + " ");

        br.close();
    }
}
