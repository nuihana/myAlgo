package BaekJoon.Solve2023.QueueAndDdqueue;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1021 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int queueSize = Integer.parseInt(st.nextToken());
        int targetCase = Integer.parseInt(st.nextToken());
        JduDequeue dequeue = new JduDequeue();

        st = new StringTokenizer(br.readLine());
        int result = 0;

        for (int i = 1; i <= queueSize; i++) {
            dequeue.push_back(i);
        }

        for (int i = 0; i < targetCase; i++) {
            int target = Integer.parseInt(st.nextToken());

            int frontLength = 0;
            int rearLength = 1;

            Node item = dequeue.front();
            while(item.getValue() != target) {
                item = item.getNextNode();
                frontLength++;
            }

            item = dequeue.back();
            while(item.getValue() != target) {
                item = item.getPrevNode();
                rearLength++;
            }

            if (frontLength < rearLength) {
                while(dequeue.front().getValue() != target) {
                    dequeue.push_back(dequeue.pop_front().getValue());
                    result++;
                }

                dequeue.pop_front();
            } else {
                while(dequeue.front().getValue() != target) {
                    dequeue.push_front(dequeue.pop_back().getValue());
                    result++;
                }

                dequeue.pop_front();
            }
        }

        bw.write(Integer.toString(result));

        br.close();
        bw.close();
    }

    class JduDequeue {
        Node front, rear;
        int size;

        public JduDequeue() {
            front = rear = null;
            size = 0;
        }

        public void push_front(int value) {
            Node item = new Node(value);
            if (empty() == 1) {
                front = rear = item;
            } else {
                front.setPrevNode(item);
                item.setNextNode(front);
                front = item;
            }
            size++;
        }

        public void push_back(int value) {
            Node item = new Node(value);
            if (empty() == 1) {
                front = rear = item;
            } else {
                rear.setNextNode(item);
                item.setPrevNode(rear);
                rear = item;
            }
            size++;
        }

        public Node pop_front() {
            if (empty() == 1) {
                return null;
            } else {
                Node item = front;

                size--;

                if (size == 0) {
                    front = rear = null;
                } else {
                    front = item.getNextNode();
                    front.setPrevNode(null);
                }

                return item;
            }
        }

        public Node pop_back() {
            if (empty() == 1) {
                return null;
            } else {
                Node item = rear;

                size--;

                if (size == 0) {
                    front = rear = null;
                } else {
                    rear = item.getPrevNode();
                    rear.setNextNode(null);
                }

                return item;
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

        public Node front() {
            if (empty() == 1) {
                return null;
            } else {
                return front;
            }
        }

        public Node back() {
            if (empty() == 1) {
                return null;
            } else {
                return rear;
            }
        }
    }

    class Node {
        private int value;
        Node nextNode;
        Node prevNode;

        public Node(int value) {
            this.value = value;
            nextNode = null;
            prevNode = null;
        }

        public int getValue() {
            return value;
        }
        public Node getNextNode() {
            return nextNode;
        }
        public Node getPrevNode() {
            return prevNode;
        }
        public void setNextNode(Node node) {
            this.nextNode = node;
        }
        public void setPrevNode(Node node) {
            this.prevNode = node;
        }
    }
}
