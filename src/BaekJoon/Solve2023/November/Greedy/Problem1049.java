package BaekJoon.Solve2023.November.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1049 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> sList = new ArrayList<>();
        List<Integer> oList = new ArrayList<>();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int six = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());

            sList.add(six);
            oList.add(one);
        }
        sList.sort((i1, i2) -> i1 - i2);
        oList.sort((i1, i2) -> i1 - i2);

        int res = 0;
        int minO = oList.get(0);
        int minS = sList.get(0);
        if (minO * 6 <= minS) {
            res = minO * n;
        } else {
            res = minS * (n / minS);
            n -= (n / minS);
            res += n * minO;
        }

        System.out.print(res);

        br.close();
    }
}
