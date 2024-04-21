package BaekJoon.Solve2024.April.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2961 {
    List<Taste> list;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());

            list.add(new Taste(sour, bitter));
        }

        System.out.print(getMinimumDiff(new HashSet<Integer>(), 0));

        br.close();
    }

    private int getMinimumDiff(Set<Integer> set, int start) {
        int res = 1000000000;

        if (!set.isEmpty()) {
            res = Math.min(res, getDiff(set));
        }

        for (int i = start; i < list.size(); i++) {
            set.add(i);
            res = Math.min(res, getMinimumDiff(set, i + 1));
            set.remove(i);
        }

        return res;
    }

    private int getDiff(Set<Integer> set) {
        int sour = 1;
        int bitter = 0;
        for (int idx : set) {
            Taste t = list.get(idx);

            sour *= t.sour;
            bitter += t.bitter;
        }

        return Math.abs(sour - bitter);
    }

    class Taste {
        int bitter, sour;

        public Taste(int s, int b) {
            sour = s;
            bitter = b;
        }
    }
}
