package BaekJoon.Solve2025.January.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem11502 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        List<Integer> prime = new ArrayList<>();
        boolean[] isPrime = new boolean[1001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= 1000; i++) {
            if (isPrime[i]) {
                prime.add(i);
                for (int j = 2; j * i <= 1000; j++) {
                    isPrime[j * i] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int num = Integer.parseInt(br.readLine());

            int[] res = find(prime, new int[3], 0, num);
            if (res == null) {
                sb.append(0);
            } else {
                for (int i = 0; i < res.length; i++) {
                    sb.append(res[i]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int[] find(List<Integer> prime, int[] arr, int depth, int purpose) {
        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < 3; i++) sum += arr[i];
            if (sum == purpose) return arr;
            else return null;
        }

        int[] res = null;
        for (int p : prime) {
            arr[depth] = p;
            res = find(prime, arr, depth + 1, purpose);
            if (res != null) break;
        }

        return res;
    }
}
