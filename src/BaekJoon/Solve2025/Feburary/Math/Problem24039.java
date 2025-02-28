package BaekJoon.Solve2025.Feburary.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem24039 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isPrime = new boolean[10001];
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= 10000; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j <= 10000; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        List<Integer> primeNums = new ArrayList<>();
        int bf = 2;
        for (int i = 3; i <= 10000; i++) {
            if (isPrime[i]) {
                primeNums.add(bf * i);
                bf = i;
            }
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < primeNums.size(); i++) {
            if (primeNums.get(i) > n) {
                System.out.print(primeNums.get(i));
                break;
            }
        }

        br.close();
    }
}
