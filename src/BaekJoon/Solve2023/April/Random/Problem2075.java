package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem2075 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int[][] valArr = new int[size][size];

        for(int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; st.hasMoreTokens(); j++) {
                valArr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<EndPoint> que = new PriorityQueue<>((p1, p2) -> p2.value - p1.value);
        for(int i = 0; i < size; i++) {
            que.add(new EndPoint(i, size - 1, valArr[i][size - 1]));
        }

        while(size > 0) {
            EndPoint tmp = que.poll();

            size--;
            if (tmp.valIdx > 0) {
                que.add(new EndPoint(tmp.rowIdx, tmp.valIdx - 1, valArr[tmp.rowIdx][tmp.valIdx - 1]));
            }
            if (size == 0) {
                bw.write(String.valueOf(tmp.value));
            }
        }

        br.close();
        bw.close();
    }

    class EndPoint {
        int rowIdx;
        int valIdx;
        int value;

        public EndPoint(int rowIdx_, int valIdx_, int value_) {
            this.rowIdx = rowIdx_;
            this.valIdx = valIdx_;
            this.value = value_;
        }
    }
}
