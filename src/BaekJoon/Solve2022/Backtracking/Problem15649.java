package BaekJoon.Solve2022.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15649 {
    private boolean[] isVisited;
    private int[] nums;
    private StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxNum = Integer.parseInt(st.nextToken());
        int sizeNum = Integer.parseInt(st.nextToken());

        br.close();

        isVisited = new boolean[maxNum];
        nums = new int[sizeNum];
        printNum(maxNum, sizeNum, 0);
        System.out.print(sb);
    }

    private void printNum(int maximum, int size, int depth) {
        if (size == depth) {
            for (int tmp : nums) {
                sb.append(tmp).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int idx = 0; idx < maximum; idx++) {
            if (!isVisited[idx]) {
                isVisited[idx] = true;
                nums[depth] = idx + 1;
                printNum(maximum, size, depth + 1);
                isVisited[idx] = false;
            }
        }
    }
}
