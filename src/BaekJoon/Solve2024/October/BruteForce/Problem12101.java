package BaekJoon.Solve2024.October.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12101 {
    int n, k, nth;
    boolean isDone = false;
    int[] save = new int[12];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        search(0, 0);
        if (!isDone) {
            System.out.print("-1");
        }

        br.close();
    }

    private void search(int sum, int depth) {
        if (sum > n) {
            return;
        } else if (sum == n) {
            nth++;
            if (nth == k) {
                isDone = true;
                for (int i = 0; i < depth - 1; i++) {
                    System.out.print(save[i] + "+");
                }
                System.out.print(save[depth - 1]);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            save[depth] = i;
            search(sum + i, depth + 1);
        }
    }
}
