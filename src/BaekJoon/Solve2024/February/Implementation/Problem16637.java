package BaekJoon.Solve2024.February.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem16637 {
    int len, result;
    char[] input;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        len = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();

        result = Integer.MIN_VALUE;
        solve(2, input[0] - '0');
        System.out.print(result);

        br.close();
    }

    private void solve(int idx, int sum) {
        if (idx >= len) {
            result = Math.max(result, sum);
            return;
        }

        solve(idx + 2, calc(sum, input[idx] - '0', input[idx - 1]));

        if (idx + 2 < len) {
            int right = calc(input[idx] - '0', input[idx + 2] - '0', input[idx + 1]);
            int left = calc(sum, right, input[idx - 1]);
            solve(idx + 4, left);
        }
    }

    private int calc(int i, int j, char op) {
        if (op == '+') return i + j;
        else if (op == '-') return i - j;
        else return i * j;
    }
}
