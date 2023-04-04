package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.*;

public class Problem1182 {
    int numCnt;
    int purpose;
    int[] numArr;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        numCnt = Integer.parseInt(st.nextToken());
        purpose = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numArr = new int[numCnt];
        for (int i = 0 ; i < numCnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 1; i <= numCnt; i++) {
            result += getPartArr(0, i, 0, 0);
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private int getPartArr(int depth, int len, int num, int start) {
        if (depth == len) {
            if (purpose == num) {
                return 1;
            } else {
                return 0;
            }
        }

        int tmp = num;
        int result = 0;
        for (int i = start; i < numCnt; i++) {
            result += getPartArr(depth + 1, len, tmp + numArr[i], i + 1);
        }

        return result;
    }
}
