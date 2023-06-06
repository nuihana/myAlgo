package BaekJoon.Solve2023.June.LowestCommonAncestor;

import java.io.*;
import java.util.StringTokenizer;

public class Problem17435 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nodeCnt = Integer.parseInt(br.readLine());
        int[][] nodeArr = new int[nodeCnt + 1][20];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= nodeCnt; i++) {
            nodeArr[i][0] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j <= nodeCnt; j++) {
                nodeArr[j][i] = nodeArr[nodeArr[j][i - 1]][i - 1];
            }
        }

        int commandCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < commandCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            for (int j = 19; j >= 0; j--) {
                if ((n & (1 << j)) > 0) {
                    idx = nodeArr[idx][j];
                }
            }

            bw.write(String.valueOf(idx));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
