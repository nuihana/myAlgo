package BaekJoon.DynamicPlanning;

import java.io.*;
import java.util.StringTokenizer;

public class Problem9184 {
    int[][][] arr = new int[20][20][20];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean flag = true;

        while(flag) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                flag = false;
                break;
            }

            bw.write("w(" + a + ", " + b + ", " + c + ") = " + recursive(a, b, c));
            bw.flush();
        }

        br.close();
        bw.close();
    }

    private int recursive(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c<= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return arr[19][19][19] = recursive(20, 20, 20);
        }

        if (arr[a - 1][b - 1][c - 1] > 0) {
            return arr[a - 1][b - 1][c - 1];
        }

        if (a < b && b < c) {
            return arr[a - 1][b - 1][c - 1] = recursive(a, b, c - 1) + recursive(a, b - 1, c - 1) - recursive(a, b - 1, c);
        }

        return arr[a - 1][b - 1][c - 1] = recursive(a - 1, b, c) + recursive(a - 1, b - 1, c) + recursive(a - 1, b, c - 1) - recursive(a - 1, b - 1, c - 1);
    }
}
