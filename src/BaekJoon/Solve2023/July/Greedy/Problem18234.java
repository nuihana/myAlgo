package BaekJoon.Solve2023.July.Greedy;

import java.io.*;
import java.util.*;

public class Problem18234 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int carrotCnt = Integer.parseInt(st.nextToken());
        int growDay = Integer.parseInt(st.nextToken());

        List<long[]> carrotList = new ArrayList<>();
        for (int i = 0; i < carrotCnt; i++) {
            st = new StringTokenizer(br.readLine());
            long init = Long.parseLong(st.nextToken());
            long grow = Long.parseLong(st.nextToken());

            carrotList.add(new long[]{init, grow});
        }
        carrotList.sort((a1, a2) -> Long.compare(a1[1], a2[1]));

        long res = 0;
        for (int i = 0; i < carrotCnt; i++) {
            res += carrotList.get(i)[0] + carrotList.get(i)[1] * (growDay - carrotCnt + i);
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }
}
