package BaekJoon.Solve2024.January.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11728 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        int[] aArr = new int[aSize];
        int[] bArr = new int[bSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(aArr);
        Arrays.sort(bArr);

        int aPointer = 0;
        int bPointer = 0;
        StringBuilder sb = new StringBuilder();
        while (aPointer < aSize || bPointer < bSize) {
            int a, b;
            if (aPointer >= aSize) {
                sb.append(bArr[bPointer]).append(" ");
                bPointer++;
                continue;
            } else if (bPointer >= bSize) {
                sb.append(aArr[aPointer]).append(" ");
                aPointer++;
                continue;
            }
            a = aArr[aPointer];
            b = bArr[bPointer];

            if (a < b) {
                sb.append(a).append(" ");
                aPointer++;
            } else if (b < a) {
                sb.append(b).append(" ");
                bPointer++;
            } else {
                aPointer++;
                bPointer++;
                sb.append(a).append(" ").append(b).append(" ");
            }
        }

        System.out.print(sb);

        br.close();
    }
}
