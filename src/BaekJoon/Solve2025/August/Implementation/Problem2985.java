package BaekJoon.Solve2025.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2985 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.print(getRes(a, b, c));

        br.close();
    }

    private String getRes(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        if (a + b == c) {
            sb.append(a).append("+").append(b).append("=").append(c);
        } else if (a - b == c) {
            sb.append(a).append("-").append(b).append("=").append(c);
        } else if (a * b == c) {
            sb.append(a).append("*").append(b).append("=").append(c);
        } else if (a / b == c) {
            sb.append(a).append("/").append(b).append("=").append(c);
        } else if (a == b + c) {
            sb.append(a).append("=").append(b).append("+").append(c);
        } else if (a == b - c) {
            sb.append(a).append("=").append(b).append("-").append(c);
        } else if (a == b * c) {
            sb.append(a).append("=").append(b).append("*").append(c);
        } else if (a == b / c) {
            sb.append(a).append("=").append(b).append("/").append(c);
        }
        return sb.toString();
    }
}
