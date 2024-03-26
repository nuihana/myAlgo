package BaekJoon.Solve2024.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2503 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int queryCnt = Integer.parseInt(br.readLine());
        boolean[] used = new boolean[10];
        List<Query> qList = new ArrayList<>();
        for (int i = 0; i < queryCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String n = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            qList.add(new Query(n, s, b));
        }

        System.out.print(search("", 0, used, qList));

        br.close();
    }

    private int search(String src, int depth, boolean[] used, List<Query> qList) {
        if (depth == 3) {
            return chk(src, qList);
        }

        int res = 0;
        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                res += search(src + i, depth + 1, used, qList);
                used[i] = false;
            }
        }

        return res;
    }

    private int chk(String query, List<Query> qList) {
        for (Query q : qList) {
            int s = 0;
            int b = 0;
            for (int i = 0; i < 3; i++) {
                if (q.num.charAt(i) == query.charAt(i)) s++;
            }

            if (q.s != s) return 0;

            for (int i = 0; i < 3; i++) {
                int tmp = (i + 1) % 3;
                if (query.charAt(i) == q.num.charAt(tmp)) b++;

                tmp = (i + 2) % 3;
                if (query.charAt(i) == q.num.charAt(tmp)) b++;
            }

            if (q.b != b) return 0;
        }

        return 1;
    }

    class Query {
        String num;
        int s, b;
        public Query(String number, int strike, int ball) {
            num = number;
            s = strike;
            b = ball;
        }
    }
}
