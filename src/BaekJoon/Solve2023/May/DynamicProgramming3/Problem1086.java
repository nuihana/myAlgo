package BaekJoon.Solve2023.May.DynamicProgramming3;

import java.io.*;
import java.util.Arrays;

public class Problem1086 {
    int numCnt;
    String[] numArr;
    int modVal;
    long[][] dp;
    int[][] modArr;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        numCnt = Integer.parseInt(br.readLine());
        numArr = new String[numCnt];
        for (int i = 0; i < numCnt; i++) {
            numArr[i] = br.readLine();
        }
        modVal = Integer.parseInt(br.readLine());
        dp = new long[modVal][(1 << numCnt)];
        modArr = new int[modVal][numCnt];
        for (int i = 0; i < modVal; i++) {
            Arrays.fill(dp[i], -1);
            Arrays.fill(modArr[i], -1);
        }

        long isZero = memoization(0, 0);
        long total = factorial(numCnt);
        if (isZero == 0) {
            bw.write("0/1");
        } else if (total == isZero) {
            bw.write("1/1");
        } else {
            long gcd = GCD(total, isZero);
            bw.write((isZero / gcd) + "/" + (total / gcd));
        }

        br.close();
        bw.close();
    }

    private long memoization(int mod, int bitIdx) {
        if (dp[mod][bitIdx] != -1) return dp[mod][bitIdx];

        if (bitIdx == (1 << numCnt) - 1) return mod == 0 ? 1 : 0; //탐색 완료

        long cnt = 0;
        for (int i = 0; i < numCnt; i++) {
            int idx = 1 << i;
            if ((bitIdx & idx) == 0) {
                cnt += memoization(getMod(mod, i), bitIdx | idx);
            }
        }
        return dp[mod][bitIdx] = cnt;
    }

    private int getMod(int mod, int idx) {
        if (modArr[mod][idx] != -1) return modArr[mod][idx];

        int current = mod;
        for (int i = 0; i < numArr[idx].length(); i++) {
            current *= 10;
            current = (current + numArr[idx].charAt(i) - '0') % modVal;
        }

        return modArr[mod][idx] = current;
    }

    private long GCD(long a, long b) {
        if (b == 0) return a;

        return GCD(b, a % b);
    }

    private long factorial(int num) {
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
