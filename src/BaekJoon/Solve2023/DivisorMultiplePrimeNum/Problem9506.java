package BaekJoon.Solve2023.DivisorMultiplePrimeNum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem9506 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int num = Integer.parseInt(br.readLine());

            if (num == -1) {
                break;
            }

            int sqrtNum = (int) Math.sqrt(num);

            List<Integer> divisorList = new ArrayList<>();

            // 1.루트Num 까지 약수 구하기
            for (int i = 1; i <= sqrtNum; i++) {
                if (num % i == 0) {
                    divisorList.add(i);
                }
            }

            // 2.에서 구한 대칭 약수 구해서 넣기
            for (int i = divisorList.size() - 1; i > 0; i--) {
                divisorList.add(num / divisorList.get(i));
            }

            int divisorSum = 0;
            StringBuilder divisorStr = new StringBuilder(num + " = ");
            for (int tmp : divisorList) {
                divisorSum += tmp;
                divisorStr.append(tmp + " + ");
            }
            divisorStr.delete(divisorStr.lastIndexOf(" + "), divisorStr.lastIndexOf(" + ") + 3);

            if (divisorSum == num) {
                System.out.println(divisorStr);
            } else {
                System.out.println(num + " is NOT perfect.");
            }
        }

        br.close();
    }
}
