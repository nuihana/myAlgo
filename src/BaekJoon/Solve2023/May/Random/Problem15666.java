package BaekJoon.Solve2023.May.Random;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15666 {
    int[] numArr;
    int[] sequence;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int seqLen = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numArr = new int[numCnt];
        for (int i = 0; st.hasMoreTokens(); i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numArr);
        sequence = new int[seqLen];
        dfs(seqLen, 0, 0);

        br.close();
    }

    private void dfs(int depth, int idx, int start) {
        if (idx == depth) {
            for (int i = 0; i < sequence.length; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }

        boolean[] used = new boolean[10001];
        for (int i = start; i < numArr.length; i++) {
            if (!used[numArr[i]]) {
                used[numArr[i]] = true;
                sequence[idx] = numArr[i];
                dfs(depth, idx + 1, i);
            }
        }
    }
}
