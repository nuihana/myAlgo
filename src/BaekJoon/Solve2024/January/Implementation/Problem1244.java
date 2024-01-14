package BaekJoon.Solve2024.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1244 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int switchCnt = Integer.parseInt(br.readLine());
        int[] switches = new int[switchCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < switchCnt; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentCnt = Integer.parseInt(br.readLine());
        while (studentCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int i = 1; i * idx <= switchCnt; i++) {
                    switches[i * idx - 1] = (switches[i * idx - 1] + 1) % 2;
                }
            } else if (gender == 2) {
                int interval = 0;
                while (true) {
                    if (idx + interval > switchCnt || idx - interval <= 0) break;
                    if (switches[idx - 1 + interval] != switches[idx - 1 - interval]) break;
                    switches[idx - 1 + interval] = (switches[idx - 1 + interval] + 1) % 2;
                    if (interval > 0) switches[idx - 1 - interval] = (switches[idx - 1 - interval] + 1) % 2;
                    interval++;
                }
            }
        }

        for (int i = 0; i < switchCnt; i++) {
            System.out.print(switches[i] + " ");
            if ((i + 1) % 20 == 0) System.out.println();
        }

        br.close();
    }
}
