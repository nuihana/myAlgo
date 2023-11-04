package BaekJoon.Solve2023.November.Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem3000 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] xArr = new int[100001];
        int[] yArr = new int[100001];
        List<int[]> pList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pList.add(new int[]{ x, y });
            xArr[x]++;
            yArr[y]++;
        }

        long res = 0;
        for (int[] p : pList) {
            if (xArr[p[0]] > 1 && yArr[p[1]] > 1) {
                res += (long) (xArr[p[0]] - 1) * (yArr[p[1]] - 1);
            }
        }

        System.out.print(res);

        br.close();
    }
}
