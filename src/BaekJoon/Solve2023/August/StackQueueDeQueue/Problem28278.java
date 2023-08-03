package BaekJoon.Solve2023.August.StackQueueDeQueue;

import java.io.*;
import java.util.StringTokenizer;

public class Problem28278 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        JduStack stack = new JduStack();
        int commandCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < commandCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("1")) {
                int n = Integer.parseInt(st.nextToken());
                stack.push(n);
            } else if (command.equals("2")) {
                bw.write(String.valueOf(stack.pop()));
                bw.newLine();
            } else if (command.equals("3")) {
                bw.write(String.valueOf(stack.size()));
                bw.newLine();
            } else if (command.equals("4")) {
                if (stack.isEmpty()) {
                    bw.write("1");
                } else {
                    bw.write("0");
                }
                bw.newLine();
            } else if (command.equals("5")) {
                bw.write(String.valueOf(stack.top()));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }

    class JduStack {
        int[] data;
        int size;
        int top;

        public JduStack() {
            size = 100;
            data = new int[size];
            top = -1;
        }

        private int doubleSize() {
            if ((long) size * 2 >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return size * 2;
            }
        }

        public void push(int num) {
            if (++top == size) {
                size = doubleSize();
                int[] tmp = data;
                data = new int[size];
                System.arraycopy(tmp, 0, data, 0, tmp.length);
            }
            data[top] = num;
        }
        public int pop() {
            if (isEmpty()) {
                return -1;
            } else {
                return data[top--];
            }
        }
        public int size() {
            return top + 1;
        }
        public boolean isEmpty() {
            return top < 0;
        }
        public int top() {
            if (isEmpty()) {
                return -1;
            } else {
                return data[top];
            }
        }
    }
}
