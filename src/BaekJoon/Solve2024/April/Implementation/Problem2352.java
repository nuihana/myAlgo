package BaekJoon.Solve2024.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2352 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[cnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[cnt];
        lis[0] = arr[0];
        int idx = 1;
        for (int i = 1; i < cnt; i++) {
            if (arr[i] > lis[idx - 1]) {
                lis[idx] = arr[i];
                idx++;
            } else {
                int id = biSearch(lis, idx, arr[i]);
                lis[id] = arr[i];
            }
        }

        System.out.print(idx);

        br.close();
    }

    private int biSearch(int[] arr, int idx, int val) {
        int l = 0;
        int r = idx;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] == val) {
                l = mid;
                break;
            } else if (arr[mid] < val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
