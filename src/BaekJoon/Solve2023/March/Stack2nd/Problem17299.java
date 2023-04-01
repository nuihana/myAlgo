package BaekJoon.Solve2023.March.Stack2nd;

import java.io.*;
import java.util.*;

public class Problem17299 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrSize = Integer.parseInt(br.readLine());
        int[] arr = new int[arrSize];
        int[] freq = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrSize; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            freq[arr[i]]++;
        }

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arrSize];
        for (int i = arrSize - 1, j = 0; i >= 0; i--) {
            while(!stack.empty() && freq[stack.peek()] <= freq[arr[i]]) {
                stack.pop();
            }

            if (stack.empty()) {
                result[j] = -1;
            } else {
                result[j] = stack.peek();
            }

            stack.add(arr[i]);
            j++;
        }

        for (int i = arrSize - 1; i >= 0; i--) {
            bw.write(result[i] + " ");
        }

        br.close();
        bw.close();
    }
}