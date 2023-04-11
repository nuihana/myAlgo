package BaekJoon.Solve2023.April.DPAndBT;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2618 {
    Integer[][] dp;
    int crimeCnt;
    int[][] pathA;
    int[][] pathB;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int roadSize = Integer.parseInt(br.readLine());
        crimeCnt = Integer.parseInt(br.readLine());
        dp = new Integer[crimeCnt + 1][crimeCnt + 1];

        pathA = new int[crimeCnt + 1][2];
        pathB = new int[crimeCnt + 1][2];
        StringTokenizer st;

        pathA[0][0] = 1;
        pathA[0][1] = 1;
        pathB[0][0] = roadSize;
        pathB[0][1] = roadSize;
        for (int i = 1; i < crimeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            pathA[i][0] = from;
            pathA[i][1] = to;
            pathB[i][0] = from;
            pathB[i][1] = to;
        }

        System.out.println(getMinLength(0, 0));
        findRoute(0, 0);

        br.close();
    }

    private int getMinLength(int A, int B) {
        if (A == crimeCnt || B == crimeCnt) {
            return 0;
        }

        if (dp[A][B] != null) {
            return dp[A][B];
        }

        int crimeNum = Math.max(A, B) + 1;

        int distA = Math.abs(pathA[crimeNum][0] - pathA[A][0]) + Math.abs(pathA[crimeNum][1] - pathA[A][1]);
        int distB = Math.abs(pathB[crimeNum][0] - pathB[B][0]) + Math.abs(pathB[crimeNum][1] - pathB[B][1]);

        return dp[A][B] = Math.min(getMinLength(crimeNum, B) + distA, getMinLength(A, crimeNum) + distB);
    }

    private void findRoute(int A, int B) {
        if (A == crimeCnt || B == crimeCnt) {
            return;
        }

        int crimeNum = Math.max(A, B) + 1;

        int distA = Math.abs(pathA[crimeNum][0] - pathA[A][0]) + Math.abs(pathA[crimeNum][1] - pathA[A][1]);
        int distB = Math.abs(pathB[crimeNum][0] - pathB[B][0]) + Math.abs(pathB[crimeNum][1] - pathB[B][1]);

        int caseA = getMinLength(crimeNum, B) + distA;
        int caseB = getMinLength(A, crimeNum) + distB;

        if (caseA > caseB) {
            System.out.println(2);
            findRoute(A, crimeNum);
        } else {
            System.out.println(1);
            findRoute(crimeNum, B);
        }
    }
}
