package BaekJoon.Solve2023.June.CP_BruteForce_Recursive;

import java.io.*;
import java.util.StringTokenizer;

public class Problem16198 {
    int cnt;
    int[] energyArr;
    boolean[] used;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        cnt = Integer.parseInt(br.readLine());
        energyArr = new int[cnt];
        used = new boolean[cnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            energyArr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(dfs(0, 0)));

        br.close();
        bw.close();
    }

    private int dfs(int depth, int amount) {
        if (depth == cnt - 2) {
            return amount;
        }

        int result = 0;
        for (int i = 1; i < cnt - 1; i++) {
            if(!used[i]) {
                used[i] = true;
                result = Math.max(result, dfs(depth + 1, amount + energy(i)));
                used[i] = false;
            }
        }

        return result;
    }

    private int energy(int idx) {
        int downIdx = idx - 1;
        while(used[downIdx]) {
            downIdx--;
        }

        int upIdx = idx + 1;
        while(used[upIdx]) {
            upIdx++;
        }

        return energyArr[downIdx] + energyArr[upIdx];
    }
}
