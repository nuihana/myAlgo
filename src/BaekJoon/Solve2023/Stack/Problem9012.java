package BaekJoon.Solve2023.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9012 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commandCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < commandCnt; i++) {
            String str = br.readLine();
            JduStack stack = new JduStack();

            int flag = 2;

            for (int j = 0; j < str.length(); j++) {
                char tmp = str.charAt(j);

                if (tmp == '(') {
                    stack.push(1);
                } else if (tmp == ')') {
                    flag = Math.min(flag, stack.pop());
                }
            }

            if (stack.size() != 0) {
                flag = -1;
            }

            if (flag < 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
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
    }
}
