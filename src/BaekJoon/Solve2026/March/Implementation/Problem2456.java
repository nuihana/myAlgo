package BaekJoon.Solve2026.March.Implementation;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2456 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Score[] scores = new Score[4];
        for (int i = 0; i <= 3; i++) {
            scores[i] = new Score(i);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            scores[1].setScore(Integer.parseInt(st.nextToken()));
            scores[2].setScore(Integer.parseInt(st.nextToken()));
            scores[3].setScore(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(scores);

        if (scores[0].totalScore() != scores[1].totalScore() ||
                scores[0].first != scores[1].first ||
                scores[0].second != scores[1].second) {
            System.out.print(scores[0].idx + " " + scores[0].totalScore());
        } else {
            System.out.print("0 " + scores[0].totalScore());
        }

        br.close();
    }

    class Score implements Comparable<Score>{
        int idx;
        int first;
        int second;
        int third;

        public Score(int i) {
            idx = i;
            first = 0;
            second = 0;
            third = 0;
        }

        void setScore(int nth) {
            if (nth == 1) third++;
            if (nth == 2) second++;
            if (nth == 3) first++;
        }

        int totalScore() {
            return first * 3 + second * 2 + third;
        }

        @Override
        public int compareTo(Score o) {
            if (totalScore() == o.totalScore()) {
                if (o.first == first) {
                    return o.second - second;
                }
                return o.first - first;
            }
            return o.totalScore() - totalScore();
        }
    }
}
