package BaekJoon.Solve2025.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem9017 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Score[] scores = new Score[201];
            for (int i = 1; i <= 200; i++) {
                scores[i] = new Score();
            }

            int[] nths = new int[n + 1];
            int[] cnts = new int[201];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                int team = Integer.parseInt(st.nextToken());

                cnts[team]++;
                nths[i] = team;
            }

            int th = 1;
            for (int i = 1; i <= n; i++) {
                int team = nths[i];
                if (cnts[team] >= 6) {
                    scores[team].sum(th);
                    if (scores[team].cnt == 5) {
                        scores[team].setFifth(th);
                    }

                    th++;
                }
            }

            int res = -1;
            int topScore = Integer.MAX_VALUE;
            int fifth = 0;
            for (int i = 1; i <= 200; i++) {
                if (scores[i].isValid()) {
                    if (scores[i].getScore() < topScore) {
                        res = i;
                        topScore = scores[i].getScore();
                        fifth = scores[i].fifth;
                    } else if (scores[i].getScore() == topScore) {
                        if (scores[i].fifth < fifth) {
                            res = i;
                            topScore = scores[i].getScore();
                            fifth = scores[i].fifth;
                        }
                    }
                }
            }

            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    class Score {
        List<Integer> total;
        int fifth;
        int cnt;

        Score() {
            total = new ArrayList<>();
            fifth = 0;
            cnt = 0;
        }

        public void sum(int val) {
            total.add(val);
            cnt++;
        }
        public int getScore() {
            total.sort((i1, i2) -> i1 - i2);
            int res = 0;
            for (int i = 0; i < 4; i++) {
                res += total.get(i);
            }
            return res;
        }
        public void setFifth(int val) {
            fifth = val;
        }
        public boolean isValid() {
            return cnt >= 6;
        }
    }
}
