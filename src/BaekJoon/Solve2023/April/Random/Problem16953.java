package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16953 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(from, 1));

        int result = -1;
        while(!que.isEmpty()) {
            Node tmp = que.poll();

            long calc = tmp.value * 2;
            if (calc <= to) {
                que.add(new Node(calc, tmp.cost + 1));
            }

            calc = tmp.value * 10 + 1;
            if (calc <= to) {
                que.add(new Node(calc, tmp.cost + 1));
            }

            if (tmp.value == to) {
                result = tmp.cost;
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    class Node {
        long value;
        int cost;

        public Node(long value_, int cost_) {
            this.value = value_;
            this.cost = cost_;
        }
    }
}
