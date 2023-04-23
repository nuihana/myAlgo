package BaekJoon.Solve2023.April.Tree;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2263 {
    StringBuilder sb = new StringBuilder();
    int[] inOrder, postOrder;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nodeCnt = Integer.parseInt(br.readLine());
        inOrder = new int[nodeCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nodeCnt; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        postOrder = new int[nodeCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nodeCnt; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        getPreOrder(0, nodeCnt - 1, 0, nodeCnt - 1);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart <= inEnd && postStart <= postEnd) {
            sb.append(postOrder[postEnd] + " ");

            int idx = inStart;
            for (int i = inStart; i <= inEnd; i++) {
                if(inOrder[i] == postOrder[i]) {
                    idx = i;
                    break;
                }
            }

            getPreOrder(inStart, idx - 1, postStart, postStart + idx - inStart - 1);
            getPreOrder(idx + 1, inEnd, postStart + idx - inStart, postEnd - 1);
        }
    }
}
