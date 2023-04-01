package BaekJoon.Solve2023.March.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2110 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int houseCnt = Integer.parseInt(st.nextToken());
        int routerCnt = Integer.parseInt(st.nextToken());
        int[] houseArr = new int[houseCnt];

        int max = 0;
        for (int i = 0; i < houseCnt; i++) {
            houseArr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, houseArr[i]);
        }

        Arrays.sort(houseArr);

        System.out.print(Integer.toString(getMaximumInterval(houseArr, 0, max, routerCnt)));

        br.close();
    }

    private int getMaximumInterval(int[] arr, int begin, int end, int cnt) {
        if (begin > end) {
            return 0;
        }

        int mid = (begin + end) / 2;

        int setCnt = 0;
        for(int i = 0, setIdx = -1000000000; i < arr.length; i++) {
            if (arr[i] - setIdx >= 0) {
                setIdx = arr[i];
                setCnt++;
            }
        }

        if (setCnt >= cnt) {
            return Math.max(mid, getMaximumInterval(arr, mid + 1, end, cnt));
        } else {
            return getMaximumInterval(arr, begin, mid - 1, cnt);
        }
    }
}
