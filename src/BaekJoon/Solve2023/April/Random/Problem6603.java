package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.*;

public class Problem6603 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int numCnt = Integer.parseInt(st.nextToken());

            if(numCnt == 0) {
                break;
            }

            int[] numArr = new int[numCnt];
            for (int i = 0; i < numCnt; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }

            List<String> result = new ArrayList<>();
            getCase(0, 0, numArr, "", result);

            for (int i = 0; i < result.size(); i++) {
                bw.write(result.get(i));
                bw.newLine();
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private void getCase(int depth, int start, int[] arr, String str, List<String> result) {
        if (depth == 6) {
            result.add(str.toString());
            return;
        }

        String tmp = str;
        for (int i = start; i < arr.length; i++) {
            getCase(depth + 1, i + 1, arr, tmp + arr[i] + " ", result);
        }
    }
}
