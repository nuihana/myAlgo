package BaekJoon.Solve2026.January.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Problem9417 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> nums = new ArrayList<>();
            while (st.hasMoreTokens()) {
                nums.add(Integer.parseInt(st.nextToken()));
            }

            nums.sort(Comparator.naturalOrder());
            int res = -1;
            for (int i = 0; i < nums.size(); i++) {
                for (int j = i + 1; j < nums.size(); j++) {
                    res = Math.max(res, GCD(nums.get(j), nums.get(i)));
                }
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int GCD(int a, int b) {
        return a % b == 0 ? b : GCD(b, a % b);
    }
}
