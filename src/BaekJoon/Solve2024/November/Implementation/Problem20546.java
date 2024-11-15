package BaekJoon.Solve2024.November.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem20546 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int jh = Integer.parseInt(br.readLine());
        int sm = jh;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[14];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int jhJu = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < jh) {
                int buy = jh / arr[i];
                jh -= arr[i] * buy;
                jhJu += buy;
            }
        }
        jh += jhJu * arr[13];

        int smJu = 0;
        int increase = 0, decrease = 0;
        int bf = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (bf > arr[i]) {
                increase = 0;
                decrease++;
            } else if (bf < arr[i]) {
                decrease = 0;
                increase++;
            } else {
                increase = 0;
                decrease = 0;
            }

            if (increase >= 3) {
                sm += arr[i] * smJu;
                smJu = 0;
            }

            if (decrease >= 3) {
                int buy = sm / arr[i];
                sm -= arr[i] * buy;
                smJu += buy;
            }
        }
        sm += smJu * arr[13];

        if (jh > sm) {
            System.out.print("BNP");
        } else if (jh < sm) {
            System.out.print("TIMING");
        } else {
            System.out.print("SAMESAME");
        }

        br.close();
    }
}
