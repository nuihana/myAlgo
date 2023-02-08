package BaekJoon.QueueAndDdqueue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem11866 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrSize = Integer.parseInt(st.nextToken());
        int interval = Integer.parseInt(st.nextToken());

        JduQueue queue = new JduQueue();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= arrSize; i++) {
            queue.push(i);
        }

        for (int i = 1; queue.empty() != 1; i++) {
            if (i % interval == 0) {
                result.add(queue.pop());
            } else {
                queue.push(queue.pop());
            }
        }

        bw.write("<");
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                bw.write(result.get(i).toString());
            } else {
                bw.write(result.get(i) + ", ");
            }
        }
        bw.write(">");

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
