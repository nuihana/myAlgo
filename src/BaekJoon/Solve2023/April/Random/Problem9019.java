package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.*;

public class Problem9019 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < caseCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int inputNum = Integer.parseInt(st.nextToken());
            int purposeNum = Integer.parseInt(st.nextToken());

            Queue<Register> que = new LinkedList<>();
            Register[] visited = new Register[10000];
            que.add(new Register(inputNum));
            visited[inputNum] = que.peek();
            while (!que.isEmpty()) {
                Register tmp = que.poll();
                int calcNum = 0;

                //D - 2배
                calcNum = tmp.d();
                if (visited[calcNum] == null) {
                    visited[calcNum] = new Register(calcNum, tmp.log, "D");
                    que.add(visited[calcNum]);
                }
                //S - -1
                calcNum = tmp.s();
                if (visited[calcNum] == null) {
                    visited[calcNum] = new Register(calcNum, tmp.log, "S");
                    que.add(visited[calcNum]);
                }
                //L - 좌회전
                calcNum = tmp.l();
                if (visited[calcNum] == null) {
                    visited[calcNum] = new Register(calcNum, tmp.log, "L");
                    que.add(visited[calcNum]);
                }
                //R - 우회전
                calcNum = tmp.r();
                if (visited[calcNum] == null) {
                    visited[calcNum] = new Register(calcNum, tmp.log, "R");
                    que.add(visited[calcNum]);
                }

                if (visited[purposeNum] != null) {
                    break;
                }
            }

            bw.write(visited[purposeNum].print());
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    class Register {
        int[] value;
        List<String> log;

        public Register(int num) {
            this.value = new int[4];
            for (int i = 0; i < 4; i++) {
                value[i] = num % 10;
                num /= 10;
            }

            log = new ArrayList<>();
        }

        public Register(int num, List<String> log_, String command) {
            this.value = new int[4];
            for (int i = 0; i < 4; i++) {
                value[i] = num % 10;
                num /= 10;
            }

            this.log = new ArrayList<>(log_);
            this.log.add(command);
        }

        public boolean equals(Register another) {
            for (int i = 0; i < 4; i++) {
                if (value[i] != another.value[i]) {
                    return false;
                }
            }
            return true;
        }
        public int d() {
            int tmpNum = 0;
            for (int i = 0, upper = 0; i < 4; i++) {
                int tmp = value[i] * 2;
                if (upper > 0) {
                    tmp += upper;
                    upper = 0;
                }
                tmpNum += (tmp % 10) * (int) Math.pow(10, i);
                upper = tmp / 10;
            }

            return tmpNum;
        }
        public int s() {
            int tmpNum = 0;
            for (int i = 0; i < 4; i++) {
                tmpNum += value[i] * (int) Math.pow(10, i);
            }

            if (tmpNum > 0) {
                return tmpNum - 1;
            } else {
                return 9999;
            }
        }
        public int l() {
            int tmpNum = 0;
            for (int i = 0; i < 3; i++) {
                tmpNum += value[i] * (int) Math.pow(10, i + 1);
            }
            tmpNum += value[3];

            return tmpNum;
        }
        public int r() {
            int tmpNum = 0;
            for (int i = 1; i < 4; i++) {
                tmpNum += value[i] * (int) Math.pow(10, i - 1);
            }
            tmpNum += value[0] * 1000;

            return tmpNum;
        }
        public String print() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < log.size(); i++) {
                sb.append(log.get(i));
            }
            return sb.toString();
        }
    }
}
