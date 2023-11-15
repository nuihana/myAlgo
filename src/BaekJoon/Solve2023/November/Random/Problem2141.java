package BaekJoon.Solve2023.November.Random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2141 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<long[]> vilList = new ArrayList<>();
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());

            vilList.add(new long[]{ x, a });
            cnt += a;
        }
        vilList.sort((a1, a2) -> Long.compare(a1[0], a2[0]));

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += vilList.get(i)[1];
            if ((cnt + 1) / 2 <= result) {
                System.out.print(vilList.get(i)[0]);
                break;
            }
        }

        br.close();
    }
}
