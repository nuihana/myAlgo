package BaekJoon.Solve2023.May.CP_BFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem14226 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        Queue<Input> que = new LinkedList<>();
        boolean[][] visited = new boolean[2001][2001];
        que.offer(new Input(1, 0, 0));

        while(!que.isEmpty()) {
            Input tmp = que.poll();

            if (tmp.value == num) {
                bw.write(String.valueOf(tmp.turn));
                break;
            }

            if (tmp.copy != tmp.value) {
                que.offer(new Input(tmp.value, tmp.value, tmp.turn + 1));
            }

            if (tmp.copy > 0 && tmp.value + tmp.copy < 2000 && !visited[tmp.value + tmp.copy][tmp.copy]) {
                visited[tmp.value + tmp.copy][tmp.copy] = true;
                que.offer(new Input(tmp.value + tmp.copy, tmp.copy, tmp.turn + 1));
            }

            if (tmp.value > 0 && !visited[tmp.value - 1][tmp.copy]) {
                visited[tmp.value - 1][tmp.copy] = true;
                que.offer(new Input(tmp.value - 1, tmp.copy, tmp.turn + 1));
            }
        }

        br.close();
        bw.close();
    }

    class Input {
        int value;
        int copy;
        int turn;

        public Input(int value_, int copy_, int turn_) {
            this.value = value_;
            this.copy = copy_;
            this.turn = turn_;
        }
    }
}
