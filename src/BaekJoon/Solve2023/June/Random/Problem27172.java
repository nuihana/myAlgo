package BaekJoon.Solve2023.June.Random;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem27172 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numCnt = Integer.parseInt(br.readLine());

        int[] numArr = new int[numCnt];
        int[] score = new int[numCnt];
        List<Integer>[] game = new ArrayList[1000001];
        for (int i = 1; i <= 1000000; i++) {
            game[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());

            for (int j = 2; j * numArr[i] <= 1000000; j++) {
                game[j * numArr[i]].add(i);
            }
        }

        for (int i = 0; i < numCnt; i++) {
            int num = numArr[i];

            for (int win : game[num]) {
                score[win]++;
                score[i]--;
            }
        }

        for (int i = 0; i < numCnt; i++) {
            bw.write(score[i] + " ");
        }

        br.close();
        bw.close();
    }
}
