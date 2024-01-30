package BaekJoon.Solve2024.January.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem2143 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pur = Integer.parseInt(br.readLine());
        int aCnt = Integer.parseInt(br.readLine());
        int[] a = new int[aCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aCnt; i++) a[i] = Integer.parseInt(st.nextToken());

        int bCnt = Integer.parseInt(br.readLine());
        int[] b = new int[bCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bCnt; i++) b[i] = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> amap = new HashMap<>();
        for (int i = 0; i < aCnt; i++) {
            int sum = 0;
            for (int j = i; j < aCnt; j++) {
                sum += a[j];
                amap.compute(sum, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        Map<Integer, Integer> bmap = new HashMap<>();
        for (int i = 0; i < bCnt; i++) {
            int sum = 0;
            for (int j = i; j < bCnt; j++) {
                sum += b[j];
                bmap.compute(sum, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        long res = 0;
        for (int aVal : amap.keySet()) {
            if (bmap.get(pur - aVal) != null) res += (long) amap.get(aVal) * bmap.get(pur - aVal);
        }

        System.out.print(res);

        br.close();
    }
}
