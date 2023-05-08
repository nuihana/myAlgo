package BaekJoon.Solve2023.May.Random;

import java.io.*;
import java.util.*;

public class Problem15663 {
    int[] numArr;
    int[] sequence;
    int[] publicUses = new int[10001];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int seqLen = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numArr = new int[numCnt];
        for (int i = 0; st.hasMoreTokens(); i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
            publicUses[numArr[i]]++;
        }
        Arrays.sort(numArr);
        sequence = new int[seqLen];
        dfs(seqLen, 0);

        br.close();
        bw.close();
    }

    private void dfs(int depth, int idx) {
        if (idx == depth) {
            for (int i = 0; i < sequence.length; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }

        boolean[] used = new boolean[10001];
        for (int i = idx; i < numArr.length; i++) {
            if (!used[numArr[i]] && publicUses[numArr[i]] > 0) {
                used[numArr[i]] = true;
                publicUses[numArr[i]]--;
                sequence[idx] = numArr[i];
                dfs(depth, idx + 1);
                publicUses[numArr[i]]++;
            }
        }
    }
}
