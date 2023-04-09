package BaekJoon.Solve2023.April.DPAndBT;

import java.io.*;
import java.util.Stack;

public class Problem9252 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String strA = br.readLine();
        String strB = br.readLine();

        int a = strA.length();
        int b = strB.length();

        int[][] resultArr = new int[a + 1][b + 1];

        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if (j == 0 || i == 0) {
                    resultArr[i][j] = 0;
                } else if (strA.substring(i - 1, i).equals(strB.substring(j - 1, j))) {
                    resultArr[i][j] = resultArr[i - 1][ j - 1] + 1;
                } else {
                    resultArr[i][j] = Math.max(resultArr[i - 1][j], resultArr[i][j - 1]);
                }
            }
        }

        bw.write(String.valueOf(resultArr[a][b]));
        bw.newLine();

        Stack<String> stack = new Stack<>();
        int len = resultArr[a][b];
        int x = a;
        int y = b;
        while (len > 0) {
            if (resultArr[x - 1][y] == len) {
                x--;
                continue;
            }

            if (resultArr[x][y - 1] == len) {
                y--;
                continue;
            }

            stack.add(strA.substring(x - 1, x));
            x--;
            y--;
            len--;
        }

        while(!stack.empty()) {
            bw.write(stack.pop());
        }

        br.close();
        bw.close();
    }
}
