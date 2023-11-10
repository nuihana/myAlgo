package BaekJoon.Solve2023.November.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem1016 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long from = Long.parseLong(st.nextToken());
        long to = Long.parseLong(st.nextToken());

        Set<Long> set = new HashSet<>();
        for (long i = from; i <= to; i++) set.add(i);
        for (long i = 2; i <= 1000000; i++) {
            long pow = i * i;
            if (pow > to) break;

            long div = 1;
            if (from > pow) {
                if (from % pow == 0) {
                    div = from / pow;
                } else {
                    div = from / pow + 1;
                }
            }

            while (div * pow <= to) {
                set.remove(div * pow);
                div++;
            }
        }

        System.out.print(set.size());

        br.close();
    }
}
