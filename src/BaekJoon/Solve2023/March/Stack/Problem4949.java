package BaekJoon.Solve2023.March.Stack;

import java.io.*;

public class Problem4949 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();

            if (str.equals(".")) {
                break;
            }

            JduStack stack = new JduStack();

            str = str.replaceAll("[^\\(\\)\\[\\]]", "");

            for (int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);

                if (tmp == '(') {
                    stack.push(1);
                } else if (tmp == '[') {
                    stack.push(2);
                } else if (tmp == ')') {
                    if (stack.top() == 1) {
                        stack.pop();
                    } else {
                        stack.push(3);
                        i = str.length();
                    }
                } else if (tmp == ']') {
                    if (stack.top() == 2) {
                        stack.pop();
                    } else {
                        stack.push(3);
                        i = str.length();
                    }
                }
            }

            if (stack.size() == 0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

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

        public int top() {
            if (idx > 0) {
                return content[idx - 1];
            } else {
                return -1;
            }
        }
    }
}
