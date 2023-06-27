package BaekJoon.Solve2023.June.SweepingAlgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2170 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int lineCnt = Integer.parseInt(br.readLine());
        List<int[]> lineList = new ArrayList<>();
        for (int i = 0; i < lineCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lineList.add(new int[]{a, b});
        }

        lineList.sort((a1, a2) -> a1[0] - a2[0]);
        int[] line = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        int result = 0;
        for (int[] tmp : lineList) {
            if (tmp[0] > line[1]) {
                result += line[1] - line[0];
                line = tmp;
            } else {
                line[1] = Math.max(line[1], tmp[1]);
            }
        }
        result += line[1] - line[0];

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
