package BaekJoon.Solve2024.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1138 {
    String result;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] memory = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        search(memory, new int[n], new boolean[n + 1], 0);
        System.out.print(result);

        br.close();
    }

    private void search(int[] mem, int[] ord, boolean[] used, int depth) {
        if (depth == ord.length) {
            if (isSame(mem, ord)) {
                StringBuilder sb = new StringBuilder();
                for (int num : ord) {
                    sb.append(num).append(" ");
                }
                result = sb.toString();
                return;
            }
        }

        for (int i = 1; i <= ord.length; i++) {
            if (!used[i]) {
                used[i] = true;
                ord[depth] = i;
                search(mem, ord, used, depth + 1);
                used[i] = false;
            }
        }
    }

    private boolean isSame(int[] mem, int[] ord) {
        int[] cpr = new int[ord.length];
        for (int i = 0; i < ord.length; i++) {
            int cnt = 0;
            int now = ord[i];
            for (int j = i - 1; j >= 0; j--) {
                if (ord[i] > now) cnt++;
            }
            cpr[ord[i] - 1] = cnt;
        }

        for (int i = 0; i < mem.length; i++) {
            if (mem[i] != cpr[i]) return false;
        }
        return true;
    }
}
