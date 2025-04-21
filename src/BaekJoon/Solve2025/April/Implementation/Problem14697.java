package BaekJoon.Solve2025.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14697 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int tot = Integer.parseInt(st.nextToken());

        boolean isPossible = false;
        for (int i = 0; i * a <= tot && !isPossible; i++) {
            for (int j = 0; j * b + i * a <= tot && !isPossible; j++) {
                for (int k = 0; k * c + j * b + i * a <= tot && !isPossible; k++) {
                    if (i * a + j * b + k * c == tot) isPossible = true;
                }
            }
        }

        if (isPossible) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }

        br.close();
    }
}
