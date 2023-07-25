package BaekJoon.Solve2023.July.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1700 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int capacity = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        int[] arr = new int[cnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        int[] plug = new int[capacity];
        for (int i = 0; i < cnt; i++) {
            boolean isPluggedIn = false;
            for (int j = 0; j < capacity; j++) {
                if (plug[j] == arr[i]) {
                    isPluggedIn = true;
                    break;
                }
            }

            if (isPluggedIn) continue;

            for (int j = 0; j < capacity; j++) {
                if (plug[j] == 0) {
                    plug[j] = arr[i];
                    isPluggedIn = true;
                    break;
                }
            }

            if (isPluggedIn) continue;

            int idx = -1, deviceIdx = -1;
            for (int j = 0; j < capacity; j++) {
                int lastIdx = 0;
                for (int k = i + 1; k < cnt; k++) {
                    if (plug[j] == arr[k]) break;
                    lastIdx++;
                }

                if (lastIdx > deviceIdx) {
                    idx = j;
                    deviceIdx = lastIdx;
                }
            }
            res++;
            plug[idx] = arr[i];
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }
}
