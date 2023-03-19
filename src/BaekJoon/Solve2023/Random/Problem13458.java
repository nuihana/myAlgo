package BaekJoon.Solve2023.Random;

import java.io.*;
import java.util.StringTokenizer;

public class Problem13458 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int roomCnt = Integer.parseInt(br.readLine());
        int[] roomArr = new int[roomCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < roomCnt; i++) {
            roomArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int indiv = Integer.parseInt(st.nextToken());

        long result = 0;
        for (int i = 0; i < roomCnt; i++) {
            int tmp = roomArr[i] - total;
            result++;

            if (tmp > 0) {
                result += tmp % indiv == 0 ? tmp / indiv : tmp / indiv + 1;
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
