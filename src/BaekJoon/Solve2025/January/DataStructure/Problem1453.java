package BaekJoon.Solve2025.January.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem1453 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> isUsed = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int res = 0;
        for (int i = 0; i < n; i++) {
            int seat = Integer.parseInt(st.nextToken());
            if (isUsed.contains(seat)) {
                res++;
            } else {
                isUsed.add(seat);
            }
        }
        System.out.print(res);

        br.close();
    }
}
