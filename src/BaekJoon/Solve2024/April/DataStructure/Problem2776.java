package BaekJoon.Solve2024.April.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem2776 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (testCase-- > 0) {
            Set<Integer> saw = new HashSet<>();
            int sawCnt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < sawCnt; i++) {
                saw.add(Integer.parseInt(st.nextToken()));
            }

            int qCnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < qCnt; i++) {
                int q = Integer.parseInt(st.nextToken());
                if (saw.contains(q)) sb.append("1");
                else sb.append("0");
                sb.append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
