package BaekJoon.QueueAndDdqueue;

import java.io.*;
import java.util.StringTokenizer;

public class Problem18258 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int commandCnt = Integer.parseInt(br.readLine());
        JduQueue queue = new JduQueue();

        for (int i = 0; i < commandCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                int val = Integer.parseInt(st.nextToken());

                queue.push(val);
            } else if (command.equals("pop")) {
                bw.write(queue.pop() + "\n");
            } else if (command.equals("size")) {
                bw.write(queue.size() + "\n");
            } else if (command.equals("empty")) {
                bw.write(queue.empty() + "\n");
            } else if (command.equals("front")) {
                bw.write(queue.front() + "\n");
            } else if (command.equals("back")) {
                bw.write(queue.back() + "\n");
            }
        }

        br.close();
        bw.close();
    }

    class JduQueue {
        Node front, rear;
        int size;

        public JduQueue() {
            front = rear = null;
            size = 0;
        }

        public void push(int value) {
            Node node = new Node(value);
            if (empty() == 1) {
                front = rear = node;
            } else {
                front.setNextNode(node);
                front = node;
            }
            size++;
        }
        public int pop() {
            if (empty() == 1) {
                return -1;
            } else {
                Node popNode = rear;
                rear = rear.getNextNode();

                if (rear == null) {
                    front = null;
                }

                size--;

                return popNode.getValue();
            }
        }
        public int size() {
            return size;
        }
        public int empty() {
            if (front == null && rear == null) {
                return 1;
            } else {
                return 0;
            }
        }
        public int front() {
            if (rear == null) {
                return -1;
            } else {
                return rear.getValue();
            }
        }
        public int back() {
            if (front == null) {
                return -1;
            } else {
                return front.getValue();
            }
        }
    }

    class Node {
        private int value;
        Node nextNode;

        public Node(int value) {
            this.value = value;
            nextNode = null;
        }

        public int getValue() {
            return value;
        }
        public Node getNextNode() {
            return nextNode;
        }
        public void setNextNode(Node node) {
            this.nextNode = node;
        }
    }
}
