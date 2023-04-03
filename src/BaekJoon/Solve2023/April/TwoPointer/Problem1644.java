package BaekJoon.Solve2023.April.TwoPointer;

import java.io.*;
import java.util.*;

public class Problem1644 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        List<Integer> primeList = new ArrayList<>();
        int[] primeChkArr = new int[4000001];
        for (int i = 2; i <= 4000000; i++) {
            if (primeChkArr[i] == 0) {
                primeList.add(i);
            }

            for (int j = 2; j * i <= 4000000; j++) {
                primeChkArr[j * i] = 1;
            }
        }

        int left = 0;
        int right = 0;
        int sum = primeList.get(left);
        int caseCnt = 0;
        while (left <= right) {
            if (sum == num) {
                caseCnt++;
            }

            if (sum >= num) {
                sum -= primeList.get(left);
                left++;
            } else {
                right++;
                if (right >= primeList.size()) {
                    break;
                }
                sum += primeList.get(right);
            }
        }

        bw.write(String.valueOf(caseCnt));

        br.close();
        bw.close();
    }
}
