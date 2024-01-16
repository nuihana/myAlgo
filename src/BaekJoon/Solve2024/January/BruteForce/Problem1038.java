package BaekJoon.Solve2024.January.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem1038 {
    List<Long> list = new ArrayList<>();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 10; i++) {
            bt(i, 1);
        }
        list.sort(Comparator.naturalOrder());
        if (list.size() > n) {
            System.out.print(list.get(n));
        } else {
            System.out.print("-1");
        }

        br.close();
    }

    private void bt(long num , int idx) {
        if (idx > 10) return;

        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            bt((num * 10) + i, idx + 1);
        }
    }
}
