package BaekJoon.Solve2024.September.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2659 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int now = getCrossNum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
                , Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        List<Integer> sortList = getWholeList();

        System.out.print(sortList.indexOf(now) + 1);

        br.close();
    }

    private List<Integer> getWholeList() {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        set.add(getCrossNum(i, j, k, l));
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>(set);
        res.sort(Comparator.naturalOrder());

        return res;
    }

    private int getCrossNum(int k, int h, int t, int o) {
        int res = makeNum(k, h, t, o);
        res = Math.min(res, makeNum(h, t, o, k));
        res = Math.min(res, makeNum(t, o, k, h));
        res = Math.min(res, makeNum(o, k, h, t));
        return res;
    }

    private int makeNum(int k, int h, int t, int o) {
        return k * 1000 + h * 100 + t * 10 + o;
    }
}
