package BaekJoon.Solve2024.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem13300 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentCnt = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> roomMap = new HashMap<>();
        for (int i = 0; i < studentCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int info = s * 10 + y;
            roomMap.compute(info, (k, v) -> v == null ? 1 : v + 1);
        }

        int res = 0;
        for (int key : roomMap.keySet()) {
            res += roomMap.get(key) / capacity + (roomMap.get(key) % capacity == 0 ? 0 : 1);
        }
        System.out.print(res);

        br.close();
    }
}
