package BaekJoon.Solve2024.April.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1377 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCnt = Integer.parseInt(br.readLine());
        Number[] nums = new Number[numCnt + 1];
        for (int i = 1; i <= numCnt; i++) {
            nums[i] = new Number(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(nums, 1, numCnt + 1);

        int max = 0;
        for (int i = 1; i <= numCnt; i++) {
            max = Math.max(max, nums[i].idx - i);
        }

        System.out.print(max + 1);

        br.close();
    }

    class Number implements Comparable<Number> {
        int num, idx;

        Number(int n, int i) {
            num = n;
            idx = i;
        }

        @Override
        public int compareTo(Number o) {
            return num - o.num;
        }
    }
}
