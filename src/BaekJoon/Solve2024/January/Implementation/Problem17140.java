package BaekJoon.Solve2024.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem17140 {
    int row, col, val, rowLen = 3, colLen = 3;
    int[][] A = new int[101][101];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        val = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(solve());

        br.close();
    }

    private int solve() {
        for (int time = 0; time <= 100; time++) {
            if (A[row][col] == val) return time;
            run();
        }

        return -1;
    }

    private void run() {
        if (rowLen >= colLen) { // R 연산
            for (int i = 1; i <= rowLen; i++) {
                rOperation(i);
            }
        } else { // C 연산
            for (int i = 1; i <= colLen; i++) {
                cOperation(i);
            }
        }
    }

    private void rOperation(int key) {
        Queue<int[]> pq = new PriorityQueue<>(
                (a1, a2) -> {
                    if (a1[1] != a2[1]) return a1[1] - a2[1];
                    else return a1[0] - a2[0];
                }
        );
        Map<Integer, Integer> map = new HashMap<>(); // num, cnt

        for (int i = 1; i <= colLen; i++) {
            if (A[key][i] == 0) continue;
            map.compute(A[key][i], (num, cnt) -> cnt == null ? 1 : cnt + 1);
        }

        map.forEach((k, v) -> pq.add(new int[]{ k, v }));

        int i = 1;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            A[key][i++] = now[0];
            A[key][i++] = now[1];
        }

        colLen = Math.max(colLen, i);

        while (i <= 99) {
            A[key][i++] = 0;
            A[key][i++] = 0;
        }
    }

    private void cOperation(int key) {
        Queue<int[]> pq = new PriorityQueue<>(
                (a1, a2) -> {
                    if (a1[1] != a2[1]) return a1[1] - a2[1];
                    else return a1[0] - a2[0];
                }
        );
        Map<Integer, Integer> map = new HashMap<>(); // num, cnt

        for (int i = 1; i <= rowLen; i++) {
            if (A[i][key] == 0) continue;
            map.compute(A[i][key], (num, cnt) -> cnt == null ? 1 : cnt + 1);
        }

        map.forEach((k, v) -> pq.add(new int[]{ k, v }));

        int i = 1;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            A[i++][key] = now[0];
            A[i++][key] = now[1];
        }

        rowLen = Math.max(rowLen, i);

        while (i <= 99) {
            A[i++][key] = 0;
            A[i++][key] = 0;
        }
    }
}
