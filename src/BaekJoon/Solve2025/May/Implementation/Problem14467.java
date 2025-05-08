package BaekJoon.Solve2025.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem14467 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int acrossCnt = 0;
        Map<Integer, Integer> cowReport = new HashMap<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());

            if (cowReport.containsKey(idx) && cowReport.get(idx) != location) acrossCnt++;

            cowReport.put(idx, location);
        }
        System.out.print(acrossCnt);

        br.close();
    }
}
