package BaekJoon.Solve2023.June.Conte_SongdoCodeMaster2023;

import java.io.*;
import java.util.*;

public class Problem28236 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken()) + 2;
        int nodeCnt = Integer.parseInt(st.nextToken());

        CustomClass[] arr = new CustomClass[nodeCnt];
        for (int i = 0; i < nodeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new CustomClass(x, y);
        }

        int max = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < nodeCnt; i++) {
            int length = 0;
            length += width - arr[i].y - 1;
            length += arr[i].x - 1;

            if (max > length) {
                max = length;
                idx = i + 1;
            }
        }

        bw.write(String.valueOf(idx));

        br.close();
        bw.close();
    }

    class CustomClass {
        int x;
        int y;

        public CustomClass(int x_, int y_) {
            this.x = x_;
            this.y = y_;
        }
    }
}
