package BaekJoon.Solve2024.December.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3040 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int[] res = find(nums, new int[7], 0, 0);
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            sb.append(num).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int[] find(int[] nums, int[] res, int idx, int start) {
        if (idx == res.length) {
            int sum = 0;
            for (int num : res) {
                sum += num;
            }

            if (sum == 100) {
                return res;
            }
            return null;
        }

        for (int i = start; i < nums.length; i++) {
            res[idx] = nums[i];
            int[] tmp = find(nums, res, idx + 1, i + 1);
            if (tmp != null) return tmp;
        }

        return null;
    }
}
