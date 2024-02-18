package BaekJoon.Solve2024.February.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem6198 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int buildingCnt = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[buildingCnt];
        for (int i = 0; i < buildingCnt; i++) {
            int height = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek()[1] <= height) {
                int[] item = stack.pop();
                res[item[0]] = i - item[0] - 1;
            }
            stack.push(new int[]{ i, height });
        }
        while (!stack.isEmpty()) {
            int[] item = stack.pop();
            if (!stack.isEmpty() && stack.peek()[1] == item[1]) buildingCnt = item[0];
            res[item[0]] = buildingCnt - item[0] - 1;
        }
        long resSum = 0;
        for (int i = 0; i < res.length; i++) resSum += res[i];
        System.out.print(resSum);

        br.close();
    }
}
