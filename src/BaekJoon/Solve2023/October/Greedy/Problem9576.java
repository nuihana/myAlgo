package BaekJoon.Solve2023.October.Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem9576 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                list.add(new int[]{ from, to });
            }

            list.sort((a1, a2) -> {
                if (a1[1] == a2[1]) return a2[0] - a1[0];
                return a1[1] - a2[1];
            });

            int res = 0;
            boolean[] isUsed = new boolean[n + 1];
            for (int[] req : list) {
                for (int i = req[0]; i <= req[1]; i++) {
                    if (!isUsed[i]) {
                        isUsed[i] = true;
                        res++;
                        break;
                    }
                }
            }

            bw.write(String.valueOf(res));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
