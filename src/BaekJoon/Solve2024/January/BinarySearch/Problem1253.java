package BaekJoon.Solve2024.January.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1253 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCnt = Integer.parseInt(br.readLine());
        int[] numArr = new int[numCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numArr);

        int res = 0;
        for (int i = 0; i < numCnt; i++) {

            int now = numArr[i], l = 0, r = numCnt - 1;
            while (l < r) {
                int sum = numArr[l] + numArr[r];
                if (sum == now) {
                    if (l != i && r != i) {
                        res++;
                        break;
                    } else if (l == i) {
                        l++;
                    } else {
                        r--;
                    }
                } else if (sum < now) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        System.out.print(res);

        br.close();
    }
}
