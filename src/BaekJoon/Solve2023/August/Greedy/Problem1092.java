package BaekJoon.Solve2023.August.Greedy;

import java.io.*;
import java.util.*;

public class Problem1092 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] capa = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            capa[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(capa);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> box = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        box.sort((i1, i2) -> i2 - i1);

        if (capa[n - 1] < box.get(0)) {
            bw.write("-1");
            bw.close();
            return;
        }

        int res = 0;
        while (!box.isEmpty()) {
            int idx = 0;
            for (int i = n - 1; i >= 0;) {
                if (idx == box.size()) {
                    break;
                } else if (capa[i] >= box.get(idx)) {
                    box.remove(idx);
                    i--;
                } else {
                    idx++;
                }
            }
            res++;
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }
}
