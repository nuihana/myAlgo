package BaekJoon.Solve2025.January.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem10448 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> triNum = new ArrayList<>();
        int num = 0;
        for (int i = 1; num <= 1000; i++) {
            num += i;
            triNum.add(num);
        }
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int val = Integer.parseInt(br.readLine());
            if (isPossible(val, 3, triNum)) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }

    private boolean isPossible(int num, int cnt, List<Integer> triNum) {
        if (cnt == 0) {
            if (num == 0) return true;
            return false;
        }

        boolean res = false;
        for (int i = triNum.size() - 1; i >= 0 && !res; i--) {
            if (triNum.get(i) <= num) {
                res = isPossible(num - triNum.get(i), cnt - 1, triNum);
            }
        }

        return res;
    }
}
