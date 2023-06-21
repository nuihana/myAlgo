package BaekJoon.Solve2023.June.Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1041 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cube = new int[6];
        for (int i = 0; i < 6; i++) {
            cube[i] = Integer.parseInt(st.nextToken());
        }

        long[] min = new long[3];
        min[0] = Math.min(cube[0], cube[5]);
        min[1] = Math.min(cube[1], cube[4]);
        min[2] = Math.min(cube[2], cube[3]);
        Arrays.sort(min);

        long result = 0;
        if (size == 1) {
            result = Arrays.stream(cube).sum() - Arrays.stream(cube).max().getAsInt();
        } else {
            //한쪽 면
            result += min[0] * size * size;
            result += min[2] * 2;
            result += min[1] * (size * 3 - 2);

            result *= 2;

            int tmp = size - 2;
            while (tmp > 0) {
                result += min[0] * (size * 3 - 2);
                result += min[1] * 2;
                tmp--;
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
