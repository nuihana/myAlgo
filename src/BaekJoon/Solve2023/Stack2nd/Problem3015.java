package BaekJoon.Solve2023.Stack2nd;

import java.io.*;
import java.util.Stack;

public class Problem3015 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int peopleCnt = Integer.parseInt(br.readLine());
        int[] peopleArr = new int[peopleCnt];

        for (int i = 0; i < peopleCnt; i++) {
            peopleArr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        long result = 0;

        for (int i = 0; i < peopleCnt; i++) {
            int tmp = 0;
            long equ = 0;

            while(!stack.isEmpty() && stack.peek() < peopleArr[i]) {
                int in_tmp = stack.pop();

                if (in_tmp == tmp) {
                    equ++;
                } else {
                    equ = 0;
                    tmp = in_tmp;
                }

                if (stack.isEmpty()) {
                    result += 1;
                } else {
                    result += equ + 2;
                }
            }

            stack.push(peopleArr[i]);
        }

        int tmp = 0;
        long equ = 0;

        while(!stack.isEmpty()) {
            int in_tmp = stack.pop();

            if (in_tmp == tmp) {
                equ++;
            } else {
                equ = 0;
                tmp = in_tmp;
            }

            if (!stack.isEmpty()) {
                result += equ + 1;
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
