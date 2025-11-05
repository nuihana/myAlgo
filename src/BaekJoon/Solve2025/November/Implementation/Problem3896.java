package BaekJoon.Solve2025.November.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3896 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[1299710];
        List<Integer> primeList = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) primeList.add(i);
            for (int j = 2; i * j < isPrime.length; j++) {
                isPrime[i * j] = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());

            sb.append(find(k, primeList)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int find(int val, List<Integer> prime) {
        for (int i = 0; i < prime.size(); i++) {
            if (val == prime.get(i)) return 0;
            else if (val < prime.get(i)) return prime.get(i) - prime.get(i - 1);
        }
        return 0;
    }
}
