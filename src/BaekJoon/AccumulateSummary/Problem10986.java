package BaekJoon.AccumulateSummary;

import java.io.*;
import java.util.StringTokenizer;

public class Problem10986 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        int divisor = Integer.parseInt(st.nextToken());

        int result = 0;

        int[] sumArr = new int[cnt + 1];
        int[] modArr = new int[divisor];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < cnt + 1; i++) {
            sumArr[i] = (sumArr[i - 1] + Integer.parseInt(st.nextToken())) % divisor;
            if (sumArr[i] == 0) {
                result++;
            }
            modArr[sumArr[i]]++;
        }

        for (int i = 0; i < divisor; i++) {
            if (modArr[i] > 1) {
                result += (modArr[i] * (modArr[i] - 1) / 2);
            }
        }

        bw.write(Integer.toString(result));

        br.close();
        bw.close();
    }
}
