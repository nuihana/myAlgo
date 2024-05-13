package BaekJoon.Solve2024.May.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1783 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int res = -1;
        if (height <= 1) { // 세로축으로 움직일 수 없음
            res = 1; // 제자리만 방문 가능
        } else if (height <= 2) { // 세로로 두칸을 방문할 수 없음
            if (width < 9) {
                res = (width - 1) / 2 + 1;
            } else {
                res = 4;
            }
        } else {
            if (width < 5) {
                res = width;
            } else if (width < 7) {
                res = 4;
            } else {
                res = width - 2;
            }
        }

        System.out.print(res);

        br.close();
    }
}
