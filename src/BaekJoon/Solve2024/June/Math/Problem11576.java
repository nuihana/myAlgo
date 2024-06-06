package BaekJoon.Solve2024.June.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem11576 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int future = Integer.parseInt(st.nextToken());
        int past = Integer.parseInt(st.nextToken());

        int numLen = Integer.parseInt(br.readLine());
        int[] numArr = new int[numLen];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numLen; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int decimal = 0;
        for (int i = numLen - 1; i >= 0; i--) {
            decimal += numArr[i] * (int) Math.pow(future, numLen - i - 1);
        }

        Stack<Integer> stack = new Stack<>();
        while (decimal > 0) {
            stack.push(decimal % past);
            decimal /= past;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.print(sb);

        br.close();
    }
}
