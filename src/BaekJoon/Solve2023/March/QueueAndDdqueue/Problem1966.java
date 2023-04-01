package BaekJoon.Solve2023.March.QueueAndDdqueue;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1966 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int valSize = Integer.parseInt(st.nextToken());
            int targetVal = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            JduQueue queue = new JduQueue();

            for (int j = 0; j < valSize; j++) {
                queue.push(j, Integer.parseInt(st.nextToken()));
            }

            int result = 0;
            while (queue.front() != targetVal || queue.frontOrd() != queue.order()) {
                if (queue.frontOrd() != queue.order()) {
                    Node popNode = queue.pop();
                    queue.push(popNode.getValue(), popNode.getOrder());
                } else {
                    result++;
                    queue.pop();
                }
            }
            result++;

            bw.write(Integer.toString(result) + "\n");
        }

        br.close();
        bw.close();
    }

    class JduQueue {
        Node front, rear;
        int size;
        int maxOrd;

        public JduQueue() {
            front = rear = null;
            size = 0;
            maxOrd = Integer.MIN_VALUE;
        }

        public void push(int value, int order) {
            Node node = new Node(value, order);
            maxOrd = Math.max(order, maxOrd);
            if (empty() == 1) {
                front = rear = node;
            } else {
                front.setNextNode(node);
                front = node;
            }
            size++;
        }
        public Node pop() {
            if (empty() == 1) {
                return null;
            } else {
                Node popNode = rear;
                rear = rear.getNextNode();

                if (rear == null) {
                    front = null;
                }

                size--;

                Node item = rear;
                maxOrd = Integer.MIN_VALUE;
                while (item != null) {
                    maxOrd = Math.max(item.getOrder(), maxOrd);
                    item = item.getNextNode();
                }

                return popNode;
            }
        }
        public int size() {
            return size;
        }
        public int order() {
            return maxOrd;
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
        public int frontOrd() {
            if (rear == null) {
                return -1;
            } else {
                return rear.getOrder();
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
        private int order;
        Node nextNode;

        public Node(int value) {
            this.value = value;
            nextNode = null;
        }

        public Node(int value, int order) {
            this.value = value;
            this.order = order;
            nextNode = null;
        }

        public int getValue() {
            return value;
        }
        public int getOrder() {
            return order;
        }
        public Node getNextNode() {
            return nextNode;
        }
        public void setNextNode(Node node) {
            this.nextNode = node;
        }
    }
}
