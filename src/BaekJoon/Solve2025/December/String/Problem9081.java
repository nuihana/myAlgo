package BaekJoon.Solve2025.December.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9081 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            char[] src = br.readLine().toCharArray();
            int lastIdx = src.length - 1;
            int top = lastIdx;
            while (top > 0 && src[top - 1] >= src[top]) top--;

            if (top > 0) {
                int pos = lastIdx;
                while (src[top - 1] >= src[pos]) pos--;

                swap(src, top - 1, pos);
                while (top < lastIdx) {
                    swap(src, top, lastIdx);
                    top++;
                    lastIdx--;
                }
            }

            sb.append(src).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private void swap(char[] src, int i, int j) {
        char temp = src[i];
        src[i] = src[j];
        src[j] = temp;
    }
}
