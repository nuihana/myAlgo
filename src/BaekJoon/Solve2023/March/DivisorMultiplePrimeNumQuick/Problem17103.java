package BaekJoon.Solve2023.March.DivisorMultiplePrimeNumQuick;

import java.io.*;

public class Problem17103 {
    boolean[] primeArr = new boolean[1000001];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCnt = Integer.parseInt(br.readLine());
        setPrimeArr();

        for (int i = 0; i < testCnt; i++) {
            int num = Integer.parseInt(br.readLine());

            bw.write(String.valueOf(getPatitionCount(num)));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int getPatitionCount(int value) {
        int result = 0;
        int tmp = value / 2;
        int left = tmp;
        int right = tmp;

        while(left > 0 && right < value) {
            while (primeArr[left] && left > 0) {
                left--;
            }
            while (primeArr[right] && right < value) {
                right++;
            }

            if (left <= 1 || right >= value) {
                break;
            }

            if (left + right == value) {
                result++;
                left--;
            } else if (left + right < value) {
                right++;
            } else if (left + right > value) {
                left--;
            }
        }

        return result;
    }
    private void setPrimeArr() {
        primeArr[0] = true;
        primeArr[1] = true;

        for (int i = 2; i < primeArr.length; i++) {
            if (!primeArr[i]) {
                int j = 2;
                while (i * j < primeArr.length) {
                    primeArr[i * j] = true;
                    j++;
                }
            }
        }
    }
}
