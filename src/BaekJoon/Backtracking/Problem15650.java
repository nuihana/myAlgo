package BaekJoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15650 {
    private boolean[][] isVisited;
    private int[] nums;
    private StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxNum = Integer.parseInt(st.nextToken());
        int sizeNum = Integer.parseInt(st.nextToken());

        br.close();

        isVisited = new boolean[sizeNum][maxNum];
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
            if (!isVisited[depth][idx]) {
                for (int visIdx = depth; visIdx < size; visIdx++) {
                    isVisited[visIdx][idx] = true;
                }

                nums[depth] = idx + 1;
                printNum(maximum, size, depth + 1);

                for (int i = idx + 1; i < maximum; i++) {
                    for (int j = depth + 1; j < size; j++) {
                        isVisited[j][i] = false;
                    }
                }
            }
        }
    }
}
