package BaekJoon.Solve2023.April.DPAndBT;

import java.io.*;
import java.util.*;

public class Problem12852 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Queue<Log> que = new LinkedList<>();
        que.add(new Log(num, 0));

        while(!que.isEmpty()) {
            Log tmp = que.poll();

            if (tmp.idx == 1) {
                bw.write(String.valueOf(tmp.ord));
                bw.newLine();
                for (int i = 0; i < tmp.log.length; i++) {
                    bw.write(tmp.log[i] + " ");
                }
                break;
            }

            if (tmp.idx % 3 == 0) {
                que.add(new Log(tmp.idx / 3, tmp.ord + 1, tmp.log));
            }

            if (tmp.idx % 2 == 0) {
                que.add(new Log(tmp.idx / 2, tmp.ord + 1, tmp.log));
            }

            que.add(new Log(tmp.idx - 1, tmp.ord + 1, tmp.log));
        }

        br.close();
        bw.close();
    }
}

class Log {
    int idx;
    int ord;
    int[] log;
    public Log(int idx_, int ord_) {
        this.idx = idx_;
        this.ord = ord_;
        this.log = new int[ord_ + 1];
        this.log[ord_] = idx_;
    }
    public Log(int idx_, int ord_, int[] log_) {
        this.idx = idx_;
        this.ord = ord_;
        this.log = new int[ord_ + 1];
        System.arraycopy(log_, 0, this.log, 0, log_.length);
        this.log[ord_] = idx_;
    }
}