package BaekJoon.Solve2023.May.Geometry;

import java.io.*;
import java.util.StringTokenizer;

public class Problem25308 {
    final int STAT_CNT = 8;
    boolean[] check;
    int[] stats;
    int[] seq;
    int count = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        stats = new int[STAT_CNT];
        seq = new int[STAT_CNT];
        check = new boolean[STAT_CNT];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < STAT_CNT; i++) {
            stats[i] = Integer.parseInt(st.nextToken());
        }
        seq[0] = stats[0];
        check[0] = true;

        backtracking(1);
        bw.write(String.valueOf(count * STAT_CNT));

        br.close();
        bw.close();
    }

    private void backtracking(int depth) {
        if (depth == STAT_CNT) {
            if (isConvex(0) && isConvex(1)) count++;
            return;
        }

        for (int i = 1; i < STAT_CNT; i++) {
            if (check[i]) continue;
            seq[depth] = stats[i];
            if (depth < 2 || isConvex(depth)) {
                check[i] = true;
                backtracking(depth + 1);
                check[i] = false;
            }
        }
    }
    private boolean isConvex(int current) {
        int before = (current + STAT_CNT - 2) % STAT_CNT;
        int middle = (current + STAT_CNT - 1) % STAT_CNT;
        int next = current % STAT_CNT;
        double line = Math.sqrt(2) * seq[before] * seq[next] / (seq[before] + seq[next]);
        return seq[middle] > line;
    }
}
