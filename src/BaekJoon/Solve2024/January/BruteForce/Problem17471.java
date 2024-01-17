package BaekJoon.Solve2024.January.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem17471 {
    int n;
    List<List<Integer>> cases = new ArrayList<>();
    List<Integer>[] edges;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] peoples = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
        }

        edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken());
            edges[i] = new ArrayList<>();
            while (cnt-- > 0) {
                edges[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i < n; i++) {
            setCases(i, 0, 1, new ArrayList<>());
        }

        int res = Integer.MAX_VALUE;
        for (List<Integer> now : cases) {
            if (isPossible(now)) {
                int a = 0;
                int b = 0;
                for (int i = 1; i <= n; i++) {
                    if (now.contains(i)) a += peoples[i];
                    else b += peoples[i];
                }

                res = Math.min(res, Math.abs(a - b));
            }
        }

        System.out.print(res == Integer.MAX_VALUE ? -1 : res);

        br.close();
    }

    private void setCases(int limit, int idx, int start, List<Integer> list) {
        if (limit == idx) {
            cases.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            setCases(limit, idx + 1, i + 1, list);
            list.remove(idx);
        }
    }

    private boolean isPossible(List<Integer> list) {
        boolean[] isLinked = new boolean[n + 1];
        Queue<Integer> que = new LinkedList<>();
        isLinked[list.get(0)] = true;
        que.offer(list.get(0));

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int next : edges[now]) {
                if (!isLinked[next] && list.contains(next)) {
                    isLinked[next] = true;
                    que.offer(next);
                }
            }
        }

        for (int area : list) {
            if (!isLinked[area]) return false;
        }

        List<Integer> another = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!list.contains(i)) another.add(i);
        }

        isLinked = new boolean[n + 1];
        isLinked[another.get(0)] = true;
        que.offer(another.get(0));

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int next : edges[now]) {
                if (!isLinked[next] && another.contains(next)) {
                    isLinked[next] = true;
                    que.offer(next);
                }
            }
        }

        for (int area : another) {
            if (!isLinked[area]) return false;
        }

        return true;
    }
}
