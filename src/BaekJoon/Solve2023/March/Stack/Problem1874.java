package BaekJoon.Solve2023.March.Stack;

import java.io.*;

public class Problem1874 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int seqCnt = Integer.parseInt(br.readLine());
        int[] seqArr = new int[seqCnt];
        JduStack stack = new JduStack();

        for (int i = 0, max = 0; i < seqCnt; i++) {
            seqArr[i] = Integer.parseInt(br.readLine());

            if (seqArr[i] > max) {
                for (int j = max + 1; j <= seqArr[i]; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }

                max = seqArr[i];
            } else if (stack.top() != seqArr[i]) {
                sb = new StringBuilder();
                sb.append("NO");
                i = seqCnt;
                break;
            }

            stack.pop();
            sb.append("-\n");
        }

        System.out.print(sb.toString());
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

        public boolean empty() {
            if (idx == 0) {
                return true;
            } else {
                return false;
            }
        }

        public int top() {
            if (idx > 0) {
                return content[idx - 1];
            } else {
                return -1;
            }
        }
    }
}
