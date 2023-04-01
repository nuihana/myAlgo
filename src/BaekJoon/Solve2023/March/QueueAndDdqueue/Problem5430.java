package BaekJoon.Solve2023.March.QueueAndDdqueue;

import java.io.*;

public class Problem5430 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int commandCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < commandCnt; i++) {
            JduDequeue dequeue = new JduDequeue();
            String commandLine = br.readLine();
            int valCnt = Integer.parseInt(br.readLine());
            String val = br.readLine();
            val = val.substring(1, val.length() - 1);
            String[] valArr = val.split(",");

            for (int j = 0; j < valCnt; j++) {
                dequeue.push_back(Integer.parseInt(valArr[j]));
            }

            boolean isError = false;

            for (int j = 0, jLimit = commandLine.length(); j < jLimit; j++) {
                String command = commandLine.substring(j, j+1);

                if (command.equalsIgnoreCase("R")) {
                    dequeue.setDirection();
                } else if (command.equalsIgnoreCase("D")) {
                    Node item;
                    if (dequeue.getDirection()) {
                        item = dequeue.pop_front();
                    } else {
                        item = dequeue.pop_back();
                    }

                    if (item == null) {
                        isError = true;
                        break;
                    }
                }
            }

            if (isError) {
                bw.write("error\n");
            } else {
                Node item = dequeue.getDirection() ? dequeue.front() : dequeue.back();
                bw.write("[");
                while(item != null) {
                    if (dequeue.getDirection()) {
                        if (item.getNextNode() == null) {
                            bw.write(Integer.toString(item.getValue()));
                        } else {
                            bw.write(item.getValue() + ",");
                        }
                        item = item.getNextNode();
                    } else {
                        if (item.getPrevNode() == null) {
                            bw.write(Integer.toString(item.getValue()));
                        } else {
                            bw.write(item.getValue() + ",");
                        }
                        item = item.getPrevNode();
                    }
                }
                bw.write("]\n");
            }
        }

        br.close();
        bw.close();
    }

    class JduDequeue {
        Node front, rear;
        int size;
        boolean direction = true;

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

        public void setDirection() {
            this.direction = !direction;
        }

        public boolean getDirection() {
            return direction;
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
