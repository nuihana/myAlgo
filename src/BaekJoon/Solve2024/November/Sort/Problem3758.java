package BaekJoon.Solve2024.November.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem3758 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int teamCnt = Integer.parseInt(st.nextToken());
            int problemCnt = Integer.parseInt(st.nextToken());
            int myTeam = Integer.parseInt(st.nextToken());
            int logCnt = Integer.parseInt(st.nextToken());

            Score[] scores = new Score[teamCnt];
            for (int i = 0; i < teamCnt; i++) scores[i] = new Score(problemCnt, i);

            for (int i = 0; i < logCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken()) - 1;
                int pNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                scores[id].solve(pNum, score, i);
            }

            Arrays.sort(scores, (s1, s2) -> {
                if (s1.totalScore() != s2.totalScore()) return s2.totalScore() - s1.totalScore();
                if (s1.tryCnt != s2.tryCnt) return s1.tryCnt - s2.tryCnt;
                return s1.lastSolve - s2.lastSolve;
            });

            for (int i = 0; i < teamCnt; i++) {
                if (scores[i].idx == myTeam - 1) {
                    sb.append(i + 1).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);

        br.close();
    }

    class Score {
        int idx;
        int[] isSolved;
        int tryCnt = 0;
        int lastSolve = -1;

        Score(int p, int id) {
            isSolved = new int[p + 1];
            idx = id;
        }

        public void solve(int pNum, int score, int nth) {
            tryCnt++;
            lastSolve = nth;
            if (isSolved[pNum] < score) {
                isSolved[pNum] = score;
            }
        }

        private int totalScore() {
            int res = 0;
            for (int i = 0; i < isSolved.length; i++) res += isSolved[i];
            return res;
        }
    }
}
