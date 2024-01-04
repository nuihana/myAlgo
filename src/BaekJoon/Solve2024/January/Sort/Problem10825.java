package BaekJoon.Solve2024.January.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem10825 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Score> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            list.add(new Score(st.nextToken(), Integer.parseInt(st.nextToken())
                                , Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        list.sort((s1, s2) -> {
            if (s1.a != s2.a) return s2.a - s1.a;
            if (s1.b != s2.b) return s1.b - s2.b;
            if (s1.c != s2.c) return s2.c - s1.c;
            return s1.name.compareTo(s2.name);
        });

        StringBuilder sb = new StringBuilder();
        for (Score now : list) {
            sb.append(now.name).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    class Score {
        String name;
        int a;
        int b;
        int c;

        public Score(String n_, int a_, int b_, int c_) {
            name = n_;
            a = a_;
            b = b_;
            c = c_;
        }
    }
}
