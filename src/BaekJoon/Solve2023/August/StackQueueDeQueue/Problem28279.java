package BaekJoon.Solve2023.August.StackQueueDeQueue;

import java.io.*;
import java.util.StringTokenizer;

public class Problem28279 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        JduDequeue dequeue = new JduDequeue();
        int commandCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < commandCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("1")) {
                int n = Integer.parseInt(st.nextToken());
                dequeue.pushFront(n);
            } else if (command.equals("2")) {
                int n = Integer.parseInt(st.nextToken());
                dequeue.pushBack(n);
            } else if (command.equals("3")) {
                bw.write(String.valueOf(dequeue.popFront()));
                bw.newLine();
            } else if (command.equals("4")) {
                bw.write(String.valueOf(dequeue.popBack()));
                bw.newLine();
            } else if (command.equals("5")) {
                bw.write(String.valueOf(dequeue.size()));
                bw.newLine();
            } else if (command.equals("6")) {
                if (dequeue.isEmpty()) {
                    bw.write("1");
                } else {
                    bw.write("0");
                }
                bw.newLine();
            } else if (command.equals("7")) {
                bw.write(String.valueOf(dequeue.peekFront()));
                bw.newLine();
            } else if (command.equals("8")) {
                bw.write(String.valueOf(dequeue.peekBack()));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }

    class JduDequeue {
        int[] data;
        int front;
        int back;

        public JduDequeue() {
            data = new int[2000001];
            front = 1000001;
            back = 1000000;
        }

        public void pushFront(int num) {
            data[--front] = num;
        }
        public void pushBack(int num) {
            data[++back] = num;
        }
        public int popFront() {
            if (isEmpty()) return -1;
            return data[front++];
        }
        public int popBack() {
            if (isEmpty()) return -1;
            return data[back--];
        }
        public int size() {
            if (isEmpty()) return 0;
            return back - front + 1;
        }
        public boolean isEmpty() {
            return front > back;
        }
        public int peekFront() {
            if (isEmpty()) return -1;
            return data[front];
        }
        public int peekBack() {
            if (isEmpty()) return -1;
            return data[back];
        }
    }
}
