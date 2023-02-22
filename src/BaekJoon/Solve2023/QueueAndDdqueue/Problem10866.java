package BaekJoon.Solve2023.QueueAndDdqueue;

import java.io.*;
import java.util.StringTokenizer;

public class Problem10866 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int commandCnt = Integer.parseInt(br.readLine());
        JduDequeue dequeue = new JduDequeue();

        for (int i = 0; i < commandCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push_front")) {
                int val = Integer.parseInt(st.nextToken());

                dequeue.push_front(val);
            } else if (command.equals("push_back")) {
                int val = Integer.parseInt(st.nextToken());

                dequeue.push_back(val);
            } else if (command.equals("pop_front")) {
                Node item = dequeue.pop_front();

                int val = item == null ? -1 : item.getValue();

                bw.write(val + "\n");
            } else if (command.equals("pop_back")) {
                Node item = dequeue.pop_back();

                int val = item == null ? -1 : item.getValue();

                bw.write(val + "\n");
            } else if (command.equals("size")) {
                bw.write(dequeue.size() + "\n");
            } else if (command.equals("empty")) {
                bw.write(dequeue.empty() + "\n");
            } else if (command.equals("front")) {
                Node item = dequeue.front();

                int val = item == null ? -1 : item.getValue();

                bw.write(val + "\n");
            } else if (command.equals("back")) {
                Node item = dequeue.back();

                int val = item == null ? -1 : item.getValue();

                bw.write(val + "\n");
            }
        }

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
