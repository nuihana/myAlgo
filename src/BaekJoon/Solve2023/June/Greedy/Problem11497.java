package BaekJoon.Solve2023.June.Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11497 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            int cnt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[cnt];
            for (int i = 0; i < cnt; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int result = 0;
            for (int i = 2; i < cnt; i++) {
                result = Math.max(result, arr[i] - arr[i - 2]);
            }

            bw.write(String.valueOf(result));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
