package BaekJoon.Solve2023.April.DPAndBT;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem14003 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numCnt = Integer.parseInt(br.readLine());
        int[] numArr = new int[numCnt];
        int[] resultArr = new int[numCnt];
        int[] idxArr = new int[numCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = 1;
        for (int i = 0; i < numCnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());

            if (i == 0) {
                resultArr[0] = numArr[0];
                idxArr[0] = 0;
            } else if (i > 0) {
                if (numArr[i] > resultArr[size - 1]) {
                    resultArr[size] = numArr[i];
                    idxArr[i] = size;
                    size++;
                } else {
                    int left = 0;
                    int right = size;
                    while (left < right) {
                        int mid = (left + right) >> 1;

                        if (resultArr[mid] >= numArr[i]) {
                            right = mid;
                        } else {
                            left = mid + 1;
                        }
                    }

                    resultArr[right] = numArr[i];
                    idxArr[i] = right;
                }
            }
        }

        bw.write(String.valueOf(size));
        bw.newLine();

        Stack<Integer> stack = new Stack<>();
        for (int i = numCnt - 1; i >= 0; i--) {
            if (idxArr[i] == size - 1) {
                stack.push(numArr[i]);
                size--;
            }
        }

        while(!stack.empty()) {
            bw.write(stack.pop() + " ");
        }

        br.close();
        bw.close();
    }
}