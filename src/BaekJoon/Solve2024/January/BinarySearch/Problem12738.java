package BaekJoon.Solve2024.January.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12738 {
    int[] arr, lis;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[numCnt];
        lis = new int[numCnt];
        for (int i = 0; i < numCnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int j = 0;
        lis[0] = arr[0];
        int i = 1;
        while (i < numCnt) {
            if (lis[j] < arr[i]) {
                lis[++j] = arr[i];
            } else {
                int pos = binarySearch(0, j, arr[i]);
                lis[pos] = arr[i];
            }
            i++;
        }
        System.out.print(j + 1);

        br.close();
    }

    private int binarySearch(int l, int r, int val) {
        int mid;

        while (l < r) {
            mid = (l + r) / 2;
            if (lis[mid] < val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r;
    }
}
