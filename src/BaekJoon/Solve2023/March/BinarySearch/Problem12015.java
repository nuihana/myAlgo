package BaekJoon.Solve2023.March.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12015 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] seq = new int[n];
        int[] LIS = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = seq[0];
        int lengthOfLIS = 1;

        for (int i = 1; i < n; i++) {
            int key = seq[i];

            if (LIS[lengthOfLIS - 1] < key) {
                lengthOfLIS++;
                LIS[lengthOfLIS - 1] = key;
            } else {
                int lo = 0;
                int hi = lengthOfLIS;
                while (lo < hi) {
                    int mid = (lo + hi) >>> 1;

                    if(LIS[mid] < key) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }

                LIS[lo] = key;
            }
        }

        System.out.print(lengthOfLIS);

        br.close();
    }
}
