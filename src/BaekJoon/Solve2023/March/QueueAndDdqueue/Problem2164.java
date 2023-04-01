package BaekJoon.Solve2023.March.QueueAndDdqueue;

import java.io.*;

public class Problem2164 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cardCnt = Integer.parseInt(br.readLine());
        JduQueue queue = new JduQueue();

        boolean flag = false;
        for (int i = 1; i <= cardCnt; i++) {
            if (flag) {
                queue.push(i);
            }

            flag = !flag;
        }

        if (cardCnt == 1) {
            queue.push(1);
        }

        while(queue.size() != 1) {
            if (flag) {
                queue.push(queue.pop());
            } else {
                queue.pop();
            }

            flag = !flag;
        }

        bw.write(Integer.toString(queue.pop()));

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
