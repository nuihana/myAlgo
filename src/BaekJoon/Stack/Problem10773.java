package BaekJoon.Stack;

import java.io.*;
import java.util.StringTokenizer;

public class Problem10773 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commandCnt = Integer.parseInt(br.readLine());
        JduStack stack = new JduStack();

        for (int i = 0; i < commandCnt; i++) {
            int tmp = Integer.parseInt(br.readLine());

            if (tmp == 0) {
                stack.pop();
            } else {
                stack.push(tmp);
            }
        }

        System.out.print(stack.sum());

        br.close();
    }

    class JduStack {
        private int idx = 0;
        private int size = 8;
        private int[] content = new int[8];

        public void push(int value) {
            if (idx >= size) {
                size *= 2;
                int[] tmp = new int[size];
                for (int i = 0; i < content.length; i++) {
                    tmp[i] = content[i];
                }
                content = tmp;
            }

            content[idx] = value;
            idx++;
        }

        public int pop() {
            if (idx > 0) {
                idx--;
                return content[idx];
            } else {
                return -1;
            }
        }

        public int size() {
            return idx;
        }

        public int empty() {
            if (idx == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        public int top() {
            if (idx > 0) {
                return content[idx - 1];
            } else {
                return -1;
            }
        }

        public int sum() {
            int result = 0;

            for (int i = 0; i < idx; i++) {
                result += content[i];
            }

            return result;
        }
    }
}
