package BaekJoon.Solve2023.June.Geometry;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1027 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int buildingCnt = Integer.parseInt(br.readLine());
        int[] building = new int[buildingCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < buildingCnt; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        int[] see = new int[buildingCnt];
        for (int i = 0; i < buildingCnt - 1; i++) {
            int now = building[i];
            double incline = building[i + 1] - building[i];
            see[i]++;
            see[i + 1]++;
            for (int j = i + 2; j < buildingCnt; j++) {
                if (building[j] > incline * (j - i) + now) {
                    see[i]++;
                    see[j]++;
                    incline = (double) (building[j] - building[i]) / (j - i);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < buildingCnt; i++) {
            result = Math.max(result, see[i]);
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
