package BaekJoon.Solve2026.January.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem20364 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        while (q-- > 0) {
            int x = Integer.parseInt(br.readLine());

            boolean isReachable = true;
            int blockIdx = -1, tmp = x;
            while (tmp > 1) {
                if (set.contains(tmp)) {
                    blockIdx = tmp;
                    isReachable = false;
                }
                tmp /= 2;
            }

            if (isReachable) {
                sb.append(0).append("\n");
                set.add(x);
            } else {
                sb.append(blockIdx).append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
