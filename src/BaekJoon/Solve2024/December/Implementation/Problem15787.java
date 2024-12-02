package BaekJoon.Solve2024.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem15787 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] trains = new int[n][20];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int query = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            if (query == 1) {
                int seq = Integer.parseInt(st.nextToken()) - 1;
                trains[idx][seq] = 1;
            } else if (query == 2) {
                int seq = Integer.parseInt(st.nextToken()) - 1;
                trains[idx][seq] = 0;
            } else if (query == 3) {
                for (int i = 19; i > 0; i--) {
                    trains[idx][i] = trains[idx][i - 1];
                }
                trains[idx][0] = 0;
            } else {
                for (int i = 0; i < 19; i++) {
                    trains[idx][i] = trains[idx][i + 1];
                }
                trains[idx][19] = 0;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(getUnique(trains[i]));
        }

        System.out.print(set.size());

        br.close();
    }

    private int getUnique(int[] val) {
        int res = 0;

        for (int i = 0; i < val.length; i++) {
            if (val[i] > 0) res += (1 << i);
        }

        return res;
    }
}
