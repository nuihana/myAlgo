package BaekJoon.Solve2023.November.Conte_KUPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem30456 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        long res = 1;
        if (n == 0) {
            for (int i = 0; i < l - 1; i++) {
                res *= 10;
            }
        } else if (n == 1) {
            for (int i = 0; i < l - 1; i++) {
                res *= 10;
                res++;
            }
        } else {
            List<Integer> list = new ArrayList<>();
            while (n > 1) {
                for (int i = 2; i < 9; i++) {
                    if (n % i == 0) {
                        list.add(i);
                        n /= i;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int num : list) {
                sb.append(num);
            }
            l -= list.size();
            for (int i = 0; i < l; i++) {
                sb.append(1);
            }
            res = Long.parseLong(sb.toString());
        }
        System.out.print(res);

        br.close();
    }
}
