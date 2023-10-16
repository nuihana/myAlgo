package BaekJoon.Solve2023.October.Greedy;

import java.io.*;
import java.util.*;

public class Problem2457 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<int[]> rangeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fromM = Integer.parseInt(st.nextToken());
            int fromD = Integer.parseInt(st.nextToken());
            int toM = Integer.parseInt(st.nextToken());
            int toD = Integer.parseInt(st.nextToken());

            rangeList.add(new int[]{ fromM * 100 + fromD, toM * 100 + toD });
        }

        rangeList.sort((a1, a2) -> {
            if (a1[0] != a2[0]) return a1[0] - a2[0];
            return a2[1] - a1[1];
        });
        int start = 301;
        int end = 1201;
        int idx = 0;
        int max = 0;
        int cnt = 0;
        while (start < end) {
            boolean isFind = false;

            for (int i = idx; i < n; i++) {
                if (rangeList.get(i)[0] > start) {
                    break;
                }

                if (max < rangeList.get(i)[1]) {
                    isFind = true;
                    max = rangeList.get(i)[1];
                    idx = i + 1;
                }
            }

            if (isFind) {
                start = max;
                cnt++;
            } else {
                break;
            }
        }

        if (max < end) {
            bw.write("0");
        } else {
            bw.write(String.valueOf(cnt));
        }

        br.close();
        bw.close();
    }
}
