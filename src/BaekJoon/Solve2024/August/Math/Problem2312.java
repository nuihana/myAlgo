package BaekJoon.Solve2024.August.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Problem2312 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        boolean[] isPrime = setPrime();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            Map<Integer, Integer> primeFactor = new TreeMap<>();
            while (!isPrime[n]) {
                int ceil = (int) Math.sqrt(n);
                for (int i = 2; i <= ceil; i++) {
                    if (n % i == 0) {
                        n /= i;
                        primeFactor.compute(i, (k, v) -> v == null ? 1 : v + 1);
                        break;
                    }
                }
            }
            primeFactor.compute(n, (k, v) -> v == null ? 1 : v + 1);

            for (int key : primeFactor.keySet()) {
                sb.append(key).append(" ").append(primeFactor.get(key)).append("\n");
            }
        }

        System.out.print(sb);

        br.close();
    }

    private boolean[] setPrime() {
        final int size = 100000;
        boolean[] res = new boolean[size + 1];
        Arrays.fill(res, true);

        res[1] = false;
        for (int i = 2; i < size; i++) {
            if (!res[i]) continue;
            for (int j = 2; j * i <= size; j++) {
                res[i * j] = false;
            }
        }

        return res;
    }
}
