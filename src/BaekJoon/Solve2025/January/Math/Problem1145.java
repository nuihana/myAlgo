package BaekJoon.Solve2025.January.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1145 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int res = 1;
        while (!isAnswer(nums, res)) res++;
        System.out.print(res);

        br.close();
    }

    private boolean isAnswer(int[] nums, int val) {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (nums[i] <= val && val % nums[i] == 0) { cnt++; }
        }
        return cnt >= 3;
    }
}
