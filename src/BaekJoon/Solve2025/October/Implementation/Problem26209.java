package BaekJoon.Solve2025.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem26209 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isSuccess = true;
        for (int i = 0; i < 8; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n != 0 && n != 1) {
                isSuccess = false;
                break;
            }
        }
        if (isSuccess) {
            System.out.print("S");
        } else {
            System.out.print("F");
        }

        br.close();
    }
}
