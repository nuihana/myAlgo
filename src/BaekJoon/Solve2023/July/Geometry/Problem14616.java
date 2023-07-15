package BaekJoon.Solve2023.July.Geometry;

import java.io.*;
import java.util.*;

public class Problem14616 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int radCnt = Integer.parseInt(br.readLine());
        double[][] radArr = new double[radCnt][];
        for (int i = 0; i < radCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            double inc1 = (double) y1 / x1;
            double inc2 = (double) y2 / x2;

            if (inc1 > inc2) {
                radArr[i] = new double[]{inc1, inc2};
            } else {
                radArr[i] = new double[]{inc2, inc1};
            }
        }

        int laserCnt = Integer.parseInt(br.readLine());
        Double[] laserArr = new Double[laserCnt];
        for (int i = 0; i < laserCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            laserArr[i] = (double) y / x;
        }
        Arrays.sort(laserArr);

        int cnt = 0;
        for (int i = 0; i < radCnt; i++) {
            double[] rad = radArr[i];
            if (largerThan(laserArr, rad[0]) - smallerThan(laserArr, rad[1]) > 0) cnt++;
        }

        bw.write(String.valueOf(cnt));

        br.close();
        bw.close();
    }

    private int largerThan(Double[] arr, double val) {
        int begin = 0;
        int end = arr.length;

        while(begin < end) {
            int mid = (begin + end) / 2;

            if(arr[mid] <= val) {
                begin = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return end;
    }

    private int smallerThan(Double[] arr, double val) {
        int begin = 0;
        int end = arr.length;

        while(begin < end) {
            int mid = (begin + end) / 2;

            if(arr[mid] >= val) {
                end = mid;
            }
            else {
                begin = mid + 1;
            }
        }
        return end;
    }
}
