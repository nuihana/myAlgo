package BaekJoon.Solve2023.November.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1449 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Comparator.naturalOrder());
        boolean[] work = new boolean[1001];
        int res = 0;
        for (int leak : list) {
            if (!work[leak]) {
                res++;
                for (int i = leak; i < Math.min(1001, leak + l); i++) {
                    work[i] = true;
                }
            }
        }
        System.out.print(res);

        br.close();
    }
}
