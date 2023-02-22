package BaekJoon.Solve2023.Stack;

import java.io.*;
import java.util.StringTokenizer;

public class Problem10828 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int commandCnt = Integer.parseInt(br.readLine());
        JduStack stack = new JduStack();

        for (int i = 0; i < commandCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                int val = Integer.parseInt(st.nextToken());

                stack.push(val);
            } else if (command.equals("pop")) {
                bw.write(stack.pop() + "\n");
            } else if (command.equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (command.equals("empty")) {
                bw.write(stack.empty() + "\n");
            } else if (command.equals("top")) {
                bw.write(stack.top() + "\n");
            }
            bw.flush();
        }

        br.close();
        bw.close();
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
    }
}
